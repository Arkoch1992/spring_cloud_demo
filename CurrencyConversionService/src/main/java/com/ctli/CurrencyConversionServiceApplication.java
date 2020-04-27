package com.ctli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.annotation.Bean;

//import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

	
	/*
	 * @Bean public Sampler defaultSampler() { // For tracing purpose return
	 * Sampler.ALWAYS_SAMPLE; }
	 */
}