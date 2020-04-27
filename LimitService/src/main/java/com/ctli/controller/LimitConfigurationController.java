package com.ctli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctli.bean.LimitConfiguration;
import com.ctli.config.Configuration;

@RestController
public class LimitConfigurationController {

	@Autowired
	private Configuration configuration;
@GetMapping("/limit")
public LimitConfiguration retriveLimitFromConfiguration() {
	//return new LimitConfiguration(100,200) ;
	return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum()) ;
	
}	
	
}
