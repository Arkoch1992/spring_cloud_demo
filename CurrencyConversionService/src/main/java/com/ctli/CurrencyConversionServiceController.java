package com.ctli;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CurrencyConversionServiceController {

	
	  @Autowired(required = false)
	  private CurrencyExchangeServiceProxy proxy;
	  private Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		//Feign solves this problem
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8000//currency-exchange/from/{from}/to/{to}";
		Map<String,Object> uriVariables=new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean>	entity=restTemplate.getForEntity(url,CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean response=entity.getBody();
		logger.info("Currency Conversion ::{}  ", response);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
		
	}

	
	  @GetMapping(
	  "currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}") 
	  public  CurrencyConversionBean convertCurrencyFeign(@PathVariable String
	  from,@PathVariable String to,@PathVariable BigDecimal quantity) {
	  
	  
	  CurrencyConversionBean feignresponse=proxy.retriveExchangeValue(from, to); 
	  CurrencyConversionBean response=  new CurrencyConversionBean(feignresponse.getId(), from, to,
			  feignresponse.getConversionMultiple(),quantity,quantity.multiply(feignresponse. getConversionMultiple()),feignresponse.getPort());
	  logger.info("Currency Conversion ::{}  ", response);
	  return response;
	
	  
	  }
	 
	  





			 
	
	
}
