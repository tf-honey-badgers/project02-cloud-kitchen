package com.badgers.business.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.badgers.business.persistence.MenuMapper;

import lombok.Setter;

public class MenuServiceImpl implements MenuService {

	@Setter(onMethod_ = @Autowired)
	private MenuMapper mapper;
}
