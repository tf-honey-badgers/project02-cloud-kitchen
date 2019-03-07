package com.badgers.customer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.badgers.customer.persistence.PaymentMapper;

import lombok.Setter;

public class PaymentServiceImpl implements PaymentService {

	@Setter(onMethod_ = @Autowired)
	private PaymentMapper mapper;
}
