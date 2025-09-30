package com.example.demo.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CatalogController {
	@GetMapping("/")
	public String hello() {
		return "Hello ^..^";
	}

	@PostMapping("/")
	public String world() {
		return "World";
	}
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${custom.name:anonymouse}")
	private String customName;
	
	@GetMapping("/whoami")
	public String profileTest() {
		return customName + "@" + applicationName;
	}
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/catalogs/{customerId}")
	public String getCustomerInfo(@PathVariable String customerId) {
		String customerInfo = customerService.getCustomerDetail(customerId);
		
		log.debug("<<< customerId = " + customerId);
		log.debug(">>> customerInfo = " + customerInfo);
		
		return String.format("customer id %s's customer info is %s at %s", 
				customerId, customerInfo, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
		);
	}
}
