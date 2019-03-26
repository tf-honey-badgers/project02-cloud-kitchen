package org.badgers.rest.customer.order.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.badgers.rest.model.OrderInfoForViewVO;
import org.badgers.rest.model.OrderInfoMenuForViewVO;
import org.badgers.rest.model.OrderInfoVO;
import org.springframework.stereotype.Service;

@Service
public class ToOrderInfoForViewService {

	public Map<String,OrderInfoForViewVO> toOrderInfoForView(LinkedList<OrderInfoVO> list) {
		
		//{가게1:메뉴A map[] 메뉴B map[]}, {가게2:메뉴A옵션abc 메뉴B옵션abc}
		Map<String, OrderInfoForViewVO> orderInfos = new HashMap<>();
		
		for(OrderInfoVO vo:list) {
			//가게 이름으로 객체를 가져온다
			OrderInfoForViewVO innerOrderInfoForViewVO = orderInfos.get(vo.getBizName());
			//해당 가게의 객체가 없다면
			if(innerOrderInfoForViewVO==null) {
				//OrderInfoForViewVO를 생성한다
				orderInfos.put(vo.getBizName(), vo.toOrderInfoForViewVO());
				continue;
			}
			//해당 가게 객체를 가져왔다면
			Map<String, OrderInfoMenuForViewVO> menus = innerOrderInfoForViewVO.getMenus();
			//메뉴 Map에서 메뉴를 가져온다
			OrderInfoMenuForViewVO innerOrderInfoMenuForViewVO = menus.get(vo.getMenuName());
			//해당 메뉴가 없다면
			if(innerOrderInfoMenuForViewVO == null) {
				menus.put(vo.getMenuName(), vo.toOrderInfoMenuForViewVO());
				continue;
			}
			//해당 메뉴가 있다면
			Map<String, Integer> option = innerOrderInfoMenuForViewVO.getOption();
			option.put(vo.getOptName(), vo.getOptPrice());
		}
		
		return orderInfos;
	}
}
