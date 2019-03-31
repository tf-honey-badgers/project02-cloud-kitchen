package org.badgers.rest.customer.kitchen.controller;

import java.util.List;
import java.util.Map;

import org.badgers.rest.customer.kitchen.service.KitchenServiceImpl;
import org.badgers.rest.model.BizVOExtend;
import org.badgers.rest.model.CommonCodeVO;
import org.badgers.rest.model.KitchenBranchVOExtend;
import org.badgers.rest.model.KitchenSelectCatVOExtend;
import org.badgers.rest.model.MenuVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
@RequestMapping("/kitchenbranch")
public class KitchenController {
	
	@Setter(onMethod_ = { @Autowired })
	private KitchenServiceImpl service;
	
	// 지점목록
	@RequestMapping("/kitchenlist")
	public List<KitchenBranchVOExtend> kitchenbranchList(){
		return service.kitchenbranchList();
	}
	
	// 가게 목록
	@RequestMapping("/bizlist")
	public List<BizVOExtend> bizlist(){
		return service.bizlist();
	}
	
	// 메뉴 목록
	@RequestMapping("/menulist")
	public List<MenuVOExtend> menulist() {
		return service.menulist();
	}
	
	// 지점, 가게, 메뉴 목록
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/alllists", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public Map<String, List> allLists() {
		return service.allLists();
	}
	
	// 검색어를 가지고 지점, 가게, 메뉴 검색하기
	@RequestMapping(value = "/searchlists", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<List<BizVOExtend>> searchLists(@RequestBody String query) {
		List<BizVOExtend> returnVal = service.searchLists(query);
		
		return new ResponseEntity<List<BizVOExtend>>(returnVal, HttpStatus.OK);
	}
	
	// 가게 분류 코드 목록
	@RequestMapping(value = "/bizcodes", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<List<CommonCodeVO>> bizCatList() {
		List<CommonCodeVO> returnVal = service.bizCatList();
				
		return new ResponseEntity<List<CommonCodeVO>>(returnVal, HttpStatus.OK);
	}
	
	@RequestMapping("/categorization")
	public List<Object> getCategorization(){
		return service.getCategorization();
	}
	
	@RequestMapping("/nameclassification")
	List<KitchenSelectCatVOExtend> getCatKitchen(@RequestParam("comName") String comName){
		return service.getCatKitchen(comName);
	}
	
	//해당 가게의 메뉴정보를 싹다보여줌
	@RequestMapping(value="/bizinfo/{bizId}", method=RequestMethod.GET, produces="application/json")
	@Transactional
	public ResponseEntity<List<BizVOExtend>> bizInfo(@PathVariable("bizId") String bizId) {
		System.out.println("bizInfo 컨트롤러 : "+bizId);
		List<BizVOExtend> bizInfoList = service.bizInfo(bizId);
		
		if(bizInfoList.size() == 0) {
			return new ResponseEntity<List<BizVOExtend>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BizVOExtend>>(bizInfoList, HttpStatus.OK);
	}
	
	//해당 메뉴에 대한 옵션만 받아옴
	@RequestMapping(value="/menuinfo/{mIdx}", method=RequestMethod.GET, produces="application/json")
	@Transactional
	public ResponseEntity<List<MenuVOExtend>> menuInfo(@PathVariable("mIdx") int mIdx) {
		System.out.println("menuInfo : 컨트롤러");
		List<MenuVOExtend> menuOptInfo = service.getMenu(mIdx);
		if(menuOptInfo.size() == 0) {
			return new ResponseEntity<List<MenuVOExtend>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<MenuVOExtend>>(menuOptInfo, HttpStatus.OK);
	}
}