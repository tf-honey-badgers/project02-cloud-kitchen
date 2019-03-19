package org.badgers.business.menu.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

public interface MenuService {
	
	public List<?> bizGetMenu(String bizId);
	public List<?> getMenuInfo(@PathVariable("mIdx") int mIdx);
}
