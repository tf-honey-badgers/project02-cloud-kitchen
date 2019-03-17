package org.badgers.rest.customer.kitchen.service;

import java.util.List;

import org.badgers.rest.model.BizVOExtend;
import org.badgers.rest.model.KitchenBranchVOExtend;
import org.badgers.rest.model.KitchenSelectCatVOExtend;

public interface KitchenService {

	public List<KitchenBranchVOExtend> kitchenbranchList();
	public List<BizVOExtend> bizlist();
	public List<BizVOExtend> bizInfo(String bizId);
	public List<Object> getCategorization();
	public List<KitchenSelectCatVOExtend> getCatKitchen(String comName);
}
