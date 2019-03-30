package org.badgers.rest.customer.kitchen.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
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
	
	@SuppressWarnings("rawtypes")
	public Map<String, List> searchLists(String query) {
		Map<String, List> returnVal = new HashMap<String, List>();
		List<KitchenBranchVOExtend> kitchenList = mapper.kitchenbranchList();
		List<BizVOExtend> bizList = mapper.bizList();
		List<MenuVOExtend> menuList = mapper.menuList();

		try { // query 문자열은 한글이니까 encoding하여 들어오기 때문에
			query = URLDecoder.decode(query, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		query = query.substring(6); // query 문자열의 앞부분 "query=" 제거 (왜 붙는거지?!)
		String[] tokens = query.split("[\\s@&\\.,?!$+-]+"); // 공백, @, &, 마침표, 쉼표, ?, !, $, +, - 기준으로 query 문자열을 나눈다.

		// kitchenList, bizList, menuList에서 token이 있는지 검색하기
		for(String token : tokens) {
			List<KitchenBranchVOExtend> targetKitchens = new ArrayList<>();
			List<BizVOExtend> targetBizs = new ArrayList<>();
			List<MenuVOExtend> targetMenus = new ArrayList<>();
			for(KitchenBranchVOExtend kitchen : kitchenList) {
				if(kitchen.getKitchenname().contains(token)) {
					targetKitchens.add(kitchen);
				}
			}
			for(BizVOExtend biz : bizList) {
				if(biz.getBizName().contains(token)) {
					targetBizs.add(biz);
				}
			}
			for(MenuVOExtend menu : menuList) {
				if(menu.getMName().contains(token)) {
					targetMenus.add(menu);
				}
			}
			if(!targetKitchens.isEmpty()) {
				
			}
			
			
	    	System.out.println(token);
	    } 
		
		
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
