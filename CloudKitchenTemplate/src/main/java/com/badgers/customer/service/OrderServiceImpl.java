package com.badgers.customer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.badgers.customer.persistence.OrderMapper;

import lombok.Setter;

public class OrderServiceImpl implements OrderService {

	@Setter(onMethod_ = @Autowired)
	private OrderMapper mapper;
}
