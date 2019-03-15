package org.badgers.rest.customer.kitchen.persistence;

import java.util.List;

import org.badgers.rest.model.BizVO;
import org.badgers.rest.model.KitchenBranchVO;
import org.badgers.rest.model.KitchenSelectCatVOExtend;

public interface KitchenMapper {

	public List<KitchenBranchVO> kitchenbranchList();
	public List<BizVO> bizList();
	public List<BizVO> bizInfo(int bizIdx);
	public List<Object> getCategorization();
	public List<KitchenSelectCatVOExtend> getCatKitchen(String comName);
}
