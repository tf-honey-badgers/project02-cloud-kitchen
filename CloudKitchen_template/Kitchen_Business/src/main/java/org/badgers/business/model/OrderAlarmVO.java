package org.badgers.business.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class OrderAlarmVO {
	private String id;
	private String address;
	private String time;
	private String statusCode;
	private String status;
	private String msg;
	private Map<String, OrderAlarmMenuVO> menus;
	
	OrderAlarmVO(){}

	public OrderAlarmVO(String id, String address, String time, String statusCode, String status, String msg, OrderAlarmMenuVO menu) {
		super();
		
		this.id = id;
		this.address = address;
		this.time = time;
		this.statusCode = statusCode;
		this.status = status;
		this.msg = msg;
		this.menus =  new HashMap<String, OrderAlarmMenuVO>();
		addMenu(menu);
	}
	
	public void addMenu(OrderAlarmMenuVO menu) {
		//menu이름으로 map 안의 객체를 가져온다
		OrderAlarmMenuVO innerMenuVO=this.menus.get(menu.getMenuName());
		//map 안에 해당 메뉴가 없었으면
		if(innerMenuVO==null) {
			//map에 해당 메뉴를 넣어준다
			menus.put(menu.getMenuName(), menu);
			return;
		}
		//맵 안에 해당 메뉴가 있었다면
		//옵션이 없다면 return한다
		if(menu.getOptName()==null)
			return;
		//옵션이 있다면 옵션이름을 붙여준다
		innerMenuVO.setOptName(innerMenuVO.getOptName().append(","+menu.getOptName()));
		menus.put(innerMenuVO.getMenuName(), innerMenuVO);
	}
	
	
}
