package com.badgers.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badgers.customer.persistence.CustOrderMapper;

import lombok.Setter;

@Service
public class CustOrderServiceImpl implements CustOrderService {

	@Setter(onMethod_ = @Autowired)
	private CustOrderMapper mapper;
}
