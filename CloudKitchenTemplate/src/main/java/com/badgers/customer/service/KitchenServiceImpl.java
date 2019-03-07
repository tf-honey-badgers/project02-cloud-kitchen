package com.badgers.customer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.badgers.customer.persistence.KitchenMapper;

import lombok.Setter;

public class KitchenServiceImpl implements KitchenService {

	@Setter(onMethod_ = @Autowired)
	private KitchenMapper mapper;
}
