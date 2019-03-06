package com.badgers.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badgers.business.persistence.BusinessMapper;

import lombok.Setter;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Setter(onMethod_ = @Autowired)
	private BusinessMapper mapper;
}
