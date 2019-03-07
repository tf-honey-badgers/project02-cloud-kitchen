package com.badgers.business.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.badgers.business.persistence.BusinessMapper;

import lombok.Setter;

public class BusinessServiceImpl implements BusinessService {

	@Setter(onMethod_ = @Autowired)
	private BusinessMapper mapper;
}
