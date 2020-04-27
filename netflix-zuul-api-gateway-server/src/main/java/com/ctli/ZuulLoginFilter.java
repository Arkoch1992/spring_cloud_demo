package com.ctli;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
@Component
public class ZuulLoginFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		return true;// It tells run method need to be invoked
	}

	@Override
	public Object run()  {//if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter

		// It will give the Details of the Request
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("My request is ::{} , my Url is :: {}", request, request.getRequestURI());// to provide logger
																								// filter
		return null;
	}

	@Override
	public String filterType() {
		return "pre";// pre - before the request, post- after the request, error - when error occurs
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
