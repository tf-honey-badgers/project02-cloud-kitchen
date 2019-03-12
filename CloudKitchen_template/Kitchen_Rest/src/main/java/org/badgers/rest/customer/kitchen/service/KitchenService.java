package org.badgers.rest.customer.kitchen.service;

import java.util.List;

import org.badgers.rest.model.BizVo;
import org.badgers.rest.model.KitchenBranchVo;
import org.badgers.rest.model.MenuVo;

public interface KitchenService {
	public List<KitchenBranchVo> kitchenbranchList();
	public List<BizVo> bizlist();
	public List<BizVo> bizInfo();
}
