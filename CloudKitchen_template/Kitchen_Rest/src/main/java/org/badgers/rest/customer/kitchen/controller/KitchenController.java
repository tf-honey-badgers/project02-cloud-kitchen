package org.badgers.rest.customer.kitchen.controller;

import java.util.List;

import org.badgers.rest.customer.kitchen.service.KitchenServiceImpl;
import org.badgers.rest.model.BizVo;
import org.badgers.rest.model.KitchenBranchVo;
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
	public List<KitchenBranchVo> kitchenbranchList(){
		return service.kitchenbranchList();
	}
	
	// 가게 목록
	@RequestMapping("/bizlist")
	public List<BizVo> bizlist(){
		return service.bizlist();
	}
	
	@RequestMapping("/bizinfo")
	public List<BizVo> bizInfo() {
//	public List<BizVo> bizInfo(@RequestParam("bizid") String bizid) {
		System.out.println("bizInfo : 컨트롤러");
		return service.bizInfo();
	}
}
