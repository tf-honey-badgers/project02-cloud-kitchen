package org.badgers.rest.customer.kitchen.service;

import java.util.List;

import org.badgers.rest.model.BizVO;
import org.badgers.rest.model.KitchenBranchVO;
import org.badgers.rest.model.MenuVO;

public interface KitchenService {
	public List<KitchenBranchVO> kitchenbranchList();
	public List<BizVO> bizlist();
	public List<BizVO> bizInfo();
}
