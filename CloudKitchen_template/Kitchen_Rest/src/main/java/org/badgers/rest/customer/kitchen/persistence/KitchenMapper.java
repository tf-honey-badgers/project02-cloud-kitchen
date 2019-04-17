package org.badgers.rest.customer.kitchen.persistence;

import java.util.List;

import org.badgers.rest.model.BizVOExtend;
import org.badgers.rest.model.CommonCodeVO;
import org.badgers.rest.model.KitchenBranchVOExtend;
import org.badgers.rest.model.KitchenSelectCatVOExtend;
import org.badgers.rest.model.MenuVOExtend;

public interface KitchenMapper {

	public List<KitchenBranchVOExtend> kitchenbranchList();
	public List<BizVOExtend> bizList();
	public List<MenuVOExtend> menuList();
	public List<CommonCodeVO> bizCatList();
	public List<BizVOExtend> bizInfo(String bizId);
	public List<BizVOExtend> bizInfoByKitchen(String kitchenId);
	public List<BizVOExtend> bizInfoByMenu(String menuName);
	public List<Object> getCategorization();
	public List<KitchenSelectCatVOExtend> getCatKitchen(String comName);
	public List<MenuVOExtend> getMenu(int mIdx);
}
