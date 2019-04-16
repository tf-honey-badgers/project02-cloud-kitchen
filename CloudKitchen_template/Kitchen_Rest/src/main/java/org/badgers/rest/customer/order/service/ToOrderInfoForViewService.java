package org.badgers.rest.customer.order.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.badgers.rest.model.OrderInfoForViewVO;
import org.badgers.rest.model.OrderInfoMenuForViewVO;
import org.badgers.rest.model.OrderInfoVO;
import org.mortbay.log.Log;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ToOrderInfoForViewService {

	public String toOrderInfoForView(LinkedList<OrderInfoVO> list) throws JsonProcessingException {
		//{가게1:메뉴A map[] 메뉴B map[]}, {가게2:메뉴A옵션abc 메뉴B옵션abc}
		
		log.info("========================겹치는 LIST================================");
		log.info(list);
		log.info("========================겹치는 LIST================================");
		
		Map<String, OrderInfoForViewVO> orderInfos = new HashMap<>();
		for(OrderInfoVO vo:list) {
			//가게 이름으로 객체를 가져온다
			OrderInfoForViewVO innerOrderInfoForViewVO = orderInfos.get(vo.getBizName());
			System.out.println("innerOrderInfoForViewVO : "+ innerOrderInfoForViewVO);
			//해당 가게의 객체가 없다면
			if(innerOrderInfoForViewVO==null) {
				//OrderInfoForViewVO를 생성한다
				orderInfos.put(vo.getBizName(), vo.toOrderInfoForViewVO());
				continue;
			}
			//해당 가게 객체를 가져왔다면
			Map<String, OrderInfoMenuForViewVO> menus = innerOrderInfoForViewVO.getMenus();
			System.out.println("menus : "+menus);
			//메뉴 Map에서 메뉴를 가져온다
//			OrderInfoMenuForViewVO innerOrderInfoMenuForViewVO = menus.get(vo.getMenuName());
			OrderInfoMenuForViewVO innerOrderInfoMenuForViewVO = menus.get(vo.getOrderdetailId());
			System.out.println("menus.orderDId" + menus.get(vo.getOrderdetailId()));
			//해당 메뉴가 없다면
			if(innerOrderInfoMenuForViewVO == null) {
				menus.put(vo.getOrderdetailId(), vo.toOrderInfoMenuForViewVO());
				continue;
			}
			//해당 메뉴가 있다면
			Map<String, Integer> option = innerOrderInfoMenuForViewVO.getOption();
			option.put(vo.getOptName(), vo.getOptPrice());
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("==================================================orderInfos");
		System.out.println(orderInfos);
		System.out.println("==================================================orderInfos");
		String jsonOrderInfo = mapper.writeValueAsString(orderInfos);
		System.out.println("바꾸기 전  : " + jsonOrderInfo);
		

//		for(OrderInfoVO vo:list) {
//			jsonOrderInfo = jsonOrderInfo.replace(vo.getOrderdetailId(), vo.getMenuName());
//			System.out.println(jsonOrderInfo);
//		}
		
		return jsonOrderInfo;
	}
}
