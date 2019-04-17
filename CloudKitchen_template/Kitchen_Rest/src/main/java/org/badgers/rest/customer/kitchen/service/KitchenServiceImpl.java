package org.badgers.rest.customer.kitchen.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.badgers.rest.customer.kitchen.persistence.KitchenMapper;
import org.badgers.rest.model.BizVOExtend;
import org.badgers.rest.model.CommonCodeVO;
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
	
/* 자동완성용으로 키친 지점 목록 읽어오기 */
	@Override
	public List<KitchenBranchVOExtend> kitchenbranchList(){
		return mapper.kitchenbranchList();
	}

/* 자동완성용으로 가게 목록 읽어오기 */
	@Override
	public List<BizVOExtend> bizlist(){
		return mapper.bizList();
	}

/* 자동완성용으로 메뉴 목록 읽어오기 */
	@Override
	public List<MenuVOExtend> menulist(){
		return mapper.menuList();
	}
	
/* 자동완성용으로 키친 지점, 가게, 메뉴 목록 읽어오기 */
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

/* 사용자가 입력한 query를 가지고 검색하기 */
	@Override
	public List<BizVOExtend> searchLists(String query) {		
		List<BizVOExtend> returnVal = new ArrayList<>();
		List<KitchenBranchVOExtend> kitchenList = mapper.kitchenbranchList();
		List<BizVOExtend> bizList = mapper.bizList();
		List<MenuVOExtend> menuList = mapper.menuList();

		try { // query 문자열은 한글이니까 encoding하여 들어오기 때문에 처리
			query = URLDecoder.decode(query, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(query);
		
//		query = query.substring(6); // Postman으로 테스트할 때 사용
		String[] tokens = query.split("[\\s@&\\.,?!$+-]+"); // 공백, @, &, 마침표, 쉼표, ?, !, $, +, - 기준으로 query 문자열을 나눈다.
		for(String token : tokens) {
			log.info(token);
		}
		
		// kitchenList, bizList, menuList에서 token이 있는지 검색하기
		for(String token : tokens) {
			List<KitchenBranchVOExtend> targetKitchens = new ArrayList<>();
			List<BizVOExtend> targetBizs = new ArrayList<>();
			List<MenuVOExtend> targetMenus = new ArrayList<>();
			
			for(KitchenBranchVOExtend kitchen : kitchenList) { // 키친 목록 중
				if(kitchen.getKitchenname().contains(token)) { // token을 포함하는 키친이 있다면
					targetKitchens.add(kitchen); // 해당 키친을 읽어야할 목록에 추가
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

			if(!targetKitchens.isEmpty()) { // 읽어야할 키친 목록이 비어있지 않다면
				for(KitchenBranchVOExtend target : targetKitchens) {
					List<BizVOExtend> results = mapper.bizInfoByKitchen(target.getKitchenid()); // 키친 정보를 하나씩 읽는다
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
	    } 
		
		log.info("Search complete, returning to controller");
		return returnVal;
	}

	@Override
	public List<CommonCodeVO> bizCatList() {
		return mapper.bizCatList();
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