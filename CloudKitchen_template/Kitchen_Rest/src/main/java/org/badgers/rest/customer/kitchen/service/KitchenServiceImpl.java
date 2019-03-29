package org.badgers.rest.customer.kitchen.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.badgers.rest.customer.kitchen.persistence.KitchenMapper;
import org.badgers.rest.model.BizVOExtend;
import org.badgers.rest.model.KitchenBranchVOExtend;
import org.badgers.rest.model.KitchenSelectCatVOExtend;
import org.badgers.rest.model.MenuVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class KitchenServiceImpl implements KitchenService {
	
	@Setter(onMethod_=@Autowired)
	private KitchenMapper mapper;
	
	@Override
	public List<KitchenBranchVOExtend> kitchenbranchList(){
		return mapper.kitchenbranchList();
	}
	
	@Override
	public List<BizVOExtend> bizlist(){
		return mapper.bizList();
	}
		
	@Override
	public List<MenuVOExtend> menulist(){
		return mapper.menuList();
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, List> allLists() {
		Map<String, List> returnVal = new HashMap<String, List>();
		
		List<KitchenBranchVOExtend> kitchenList = mapper.kitchenbranchList();
		List<BizVOExtend> bizList = mapper.bizList();
		List<MenuVOExtend> menuList = mapper.menuList();
		
		returnVal.put("kitchenList", kitchenList);
		returnVal.put("bizList", bizList);
		returnVal.put("menuList", menuList);
		
		return returnVal;
	}
	
	@Override
	public List<BizVOExtend> bizInfo(String bizId){
		System.out.println("bizInfo : 서비스");
		return mapper.bizInfo(bizId);
	}

	@Override
	public List<Object> getCategorization() {
		return mapper.getCategorization();
	}

	@Override
	public List<KitchenSelectCatVOExtend> getCatKitchen(String comName) {
		return mapper.getCatKitchen(comName);
	}

	@Override
	public List<MenuVOExtend> getMenu(int mIdx) {
		return mapper.getMenu(mIdx);
	}
}
