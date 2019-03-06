package com.badgers.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badgers.customer.persistence.PaymentMapper;

import lombok.Setter;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Setter(onMethod_ = @Autowired)
	private PaymentMapper mapper;
}
