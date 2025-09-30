package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	public String getCustomerDetail(String customerId) {
		// TODO Auto-generated method stub
		return String.format("고객 id %s 상세정보",customerId);
	}

}
