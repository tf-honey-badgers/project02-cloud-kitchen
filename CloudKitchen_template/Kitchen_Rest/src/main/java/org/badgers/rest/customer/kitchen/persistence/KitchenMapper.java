package org.badgers.rest.customer.kitchen.persistence;

import java.util.List;

import org.badgers.rest.model.BizVOExtend;
import org.badgers.rest.model.KitchenBranchVOExtend;
import org.badgers.rest.model.KitchenSelectCatVOExtend;

public interface KitchenMapper {

	public List<KitchenBranchVOExtend> kitchenbranchList();
	public List<BizVOExtend> bizList();
	public List<BizVOExtend> bizInfo(String bizId);
	public List<Object> getCategorization();
	public List<KitchenSelectCatVOExtend> getCatKitchen(String comName);
}
