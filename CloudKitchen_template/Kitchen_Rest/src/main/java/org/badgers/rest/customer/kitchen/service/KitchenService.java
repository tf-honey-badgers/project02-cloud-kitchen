package org.badgers.rest.customer.kitchen.service;

import java.util.List;
import java.util.Map;

import org.badgers.rest.model.BizVOExtend;
import org.badgers.rest.model.CommonCodeVO;
import org.badgers.rest.model.KitchenBranchVOExtend;
import org.badgers.rest.model.KitchenSelectCatVOExtend;
import org.badgers.rest.model.MenuVOExtend;

public interface KitchenService {

	public List<KitchenBranchVOExtend> kitchenbranchList();
	public List<BizVOExtend> bizlist();
	public List<MenuVOExtend> menulist();
	
	@SuppressWarnings("rawtypes")
	public Map<String, List> allLists();
	public List<BizVOExtend> searchLists(String query);
	public List<CommonCodeVO> bizCatList();
	public List<BizVOExtend> bizInfo(String bizId);
	public List<Object> getCategorization();
	public List<KitchenSelectCatVOExtend> getCatKitchen(String comName);
	public List<MenuVOExtend> getMenu(int mIdx);
}
