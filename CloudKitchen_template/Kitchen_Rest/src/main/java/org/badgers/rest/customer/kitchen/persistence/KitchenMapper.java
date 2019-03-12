package org.badgers.rest.customer.kitchen.persistence;

import java.util.List;

import org.badgers.rest.model.BizVo;
import org.badgers.rest.model.KitchenBranchVo;

public interface KitchenMapper {
	public List<KitchenBranchVo> kitchenbranchList();
	public List<BizVo> bizList();
	public List<BizVo> bizInfo(int bizIdx);
}
