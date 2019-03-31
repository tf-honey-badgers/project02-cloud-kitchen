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
import lombok.extern.log4j.Log4j;

@Service
@Log4j
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
		
		String[] tokens = query.split("[\\s@&\\.,?!$+-]+"); // 공백, @, &, 마침표, 쉼표, ?, !, $, +, - 기준으로 query 문자열을 나눈다.
		for(String token : tokens) {
			log.info(token);
		}
		
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

			// target lists 확인용
//			System.out.println(targetKitchens);
//			System.out.println(targetBizs);
//			System.out.println(targetMenus);

			if(!targetKitchens.isEmpty()) {
				for(KitchenBranchVOExtend target : targetKitchens) {
					List<BizVOExtend> results = mapper.bizInfoByKitchen(target.getKitchenid());
					for(BizVOExtend result : results) {
						boolean flag = false;
						for(BizVOExtend returnValObject : returnVal) {
							if( returnValObject.getBizId().equals(result.getBizId()) ) {
								flag = true;
							}
						}
						if(flag == false) {
							returnVal.add(result);
						}
						flag = false;
					}
				}
			}
			if(!targetBizs.isEmpty()) {
				for(BizVOExtend target : targetBizs) {
					List<BizVOExtend> results = mapper.bizInfo(target.getBizId());
					for(BizVOExtend result : results) {
						boolean flag = false;
						for(BizVOExtend returnValObject : returnVal) {
							if( returnValObject.getBizId().equals(result.getBizId()) ) {
								flag = true;
							}
						}
						if(flag == false) {
							returnVal.add(result);
						}
						flag = false;
					}
				}
			}
			if(!targetMenus.isEmpty()) {
				for(MenuVOExtend target : targetMenus) {
					List<BizVOExtend> results = mapper.bizInfoByMenu(target.getMName());
					for(BizVOExtend result : results) {
						boolean flag = false;
						for(BizVOExtend returnValObject : returnVal) {
							if( returnValObject.getBizId().equals(result.getBizId()) ) {
								flag = true;
							}
						}
						if(flag == false) {
							returnVal.add(result);
						}
						flag = false;
					}
				}
			}
			System.out.println(returnVal);
			System.out.println(returnVal.size());
	    } 
		
		log.info("Search complete, returning to controller");
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
