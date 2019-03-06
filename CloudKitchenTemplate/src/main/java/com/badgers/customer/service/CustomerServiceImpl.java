package com.badgers.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badgers.customer.persistence.CustomerMapper;

import lombok.Setter;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Setter(onMethod_ = @Autowired)
	private CustomerMapper mapper;
}
