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
	
	@Override
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
	public List<BizVOExtend> searchLists(String query) {
		List<BizVOExtend> returnVal = new ArrayList<>();
		List<KitchenBranchVOExtend> kitchenList = mapper.kitchenbranchList();
		List<BizVOExtend> bizList = mapper.bizList();
		List<MenuVOExtend> menuList = mapper.menuList();

		try { // query 문자열은 한글이니까 encoding하여 들어오기 때문에
			query = URLDecoder.decode(query, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println(query);
		
		query = query.substring(6); // query 문자열의 앞부분 "query=" 제거 (왜 붙는거지?!)
		String[] tokens = query.split("[\\s@&\\.,?!$+-]+"); // 공백, @, &, 마침표, 쉼표, ?, !, $, +, - 기준으로 query 문자열을 나눈다.

		System.out.println("HERE 1");
		// kitchenList, bizList, menuList에서 token이 있는지 검색하기
		for(String token : tokens) {
			List<KitchenBranchVOExtend> targetKitchens = new ArrayList<>();
			List<BizVOExtend> targetBizs = new ArrayList<>();
			List<MenuVOExtend> targetMenus = new ArrayList<>();
			
			System.out.println("HERE 2");
			for(KitchenBranchVOExtend kitchen : kitchenList) {
				System.out.println("HERE 3");
				if(kitchen.getKitchenname().contains(token)) {
					System.out.println("HERE 4");
					targetKitchens.add(kitchen);
				}
			}
			System.out.println("HERE 5");
			for(BizVOExtend biz : bizList) {
				System.out.println("HERE 6");
				if(biz.getBizName().contains(token)) {
					System.out.println("HERE 7");
					targetBizs.add(biz);
				}
			}
			System.out.println("HERE 8");
			for(MenuVOExtend menu : menuList) {
				System.out.println("HERE 9");
				if(menu.getMName().contains(token)) {
					System.out.println("HERE 10");
					targetMenus.add(menu);
				}
			}
			
			System.out.println("SHOWING ALL TARGET LISTS");
			System.out.println(targetKitchens);
			System.out.println(targetBizs);
			System.out.println(targetMenus);
			
			System.out.println("HERE 11");
			if(!targetKitchens.isEmpty()) {
				System.out.println("HERE 12");
				for(KitchenBranchVOExtend target : targetKitchens) {
					System.out.println("HERE 13");
					List<BizVOExtend> results = mapper.bizInfoByKitchen(target.getKitchenid());
					for(BizVOExtend result : results) {
						System.out.println("HERE 14");
						boolean flag = false;
						for(BizVOExtend returnValObject : returnVal) {
							System.out.println("HERE 15");
							if( returnValObject.getBizId().equals(result.getBizId()) ) {
								System.out.println("HERE 16");
								flag = true;
							}
						}
						if(flag == false) {
							System.out.println("HERE 17");
							returnVal.add(result);
						}
						flag = false;
					}
				}
			}
			System.out.println("HERE 18");
			if(!targetBizs.isEmpty()) {
				System.out.println("HERE 19");
				for(BizVOExtend target : targetBizs) {
					System.out.println("HERE 20");
					List<BizVOExtend> results = mapper.bizInfo(target.getBizId());
					for(BizVOExtend result : results) {
						System.out.println("HERE 21");
						boolean flag = false;
						for(BizVOExtend returnValObject : returnVal) {
							System.out.println("HERE 22");
							if( returnValObject.getBizId().equals(result.getBizId()) ) {
								System.out.println("HERE 23");
								flag = true;
							}
						}
						if(flag == false) {
							System.out.println("HERE 24");
							returnVal.add(result);
						}
						flag = false;
					}
				}
			}
			System.out.println("HERE 25");
			if(!targetMenus.isEmpty()) {
				System.out.println("HERE 26");
				for(MenuVOExtend target : targetMenus) {
					System.out.println("HERE 27");
					List<BizVOExtend> results = mapper.bizInfoByMenu(target.getMName());
					for(BizVOExtend result : results) {
						System.out.println("HERE 28");
						boolean flag = false;
						for(BizVOExtend returnValObject : returnVal) {
							System.out.println("HERE 29");
							if( returnValObject.getBizId().equals(result.getBizId()) ) {
								System.out.println("HERE 30");
								flag = true;
							}
						}
						if(flag == false) {
							System.out.println("HERE 31");
							returnVal.add(result);
						}
						flag = false;
					}
				}
			}
			System.out.println("HERE 32");
			System.out.println(returnVal);
			System.out.println(returnVal.size());
	    } 
		
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
