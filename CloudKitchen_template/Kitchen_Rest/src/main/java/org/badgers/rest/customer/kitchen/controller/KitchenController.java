package org.badgers.rest.customer.kitchen.controller;

import java.util.List;

import org.badgers.rest.customer.kitchen.service.KitchenServiceImpl;
import org.badgers.rest.model.BizVO;
import org.badgers.rest.model.KitchenBranchVO;
import org.badgers.rest.model.KitchenSelectCatVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<KitchenBranchVO> kitchenbranchList(){
		return service.kitchenbranchList();
	}
	
	// 가게 목록
	@RequestMapping("/bizlist")
	public List<BizVO> bizlist(){
		return service.bizlist();
	}
	
	@RequestMapping("/bizinfo")
//	public List<BizVO> bizInfo() {
	public List<BizVO> bizInfo(@RequestParam("bizIdx") int bizIdx) {
		System.out.println("bizInfo : 컨트롤러");
		return service.bizInfo(bizIdx);
	}
	
	@RequestMapping("/categorization")
	public List<Object> getCategorization(){
		return service.getCategorization();
	}
	
	@RequestMapping("/nameclassification")
	List<KitchenSelectCatVOExtend> getCatKitchen(@RequestParam("comName") String comName){
		return service.getCatKitchen(comName);
	}
}
