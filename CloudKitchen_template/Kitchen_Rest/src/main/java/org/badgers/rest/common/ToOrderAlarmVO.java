package org.badgers.rest.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.badgers.rest.model.OrderAlarmVO;
import org.badgers.rest.model.OrderInfoVO;

public class ToOrderAlarmVO {

	
	public static Map<String, Map<String, OrderAlarmVO>> toOrderAlarmVO(LinkedList<OrderInfoVO> list) {
		
		Map<String, Map<String, OrderAlarmVO>> bizAndOrder = new HashMap<>();
		Map<String, OrderAlarmVO> orderAndAlarm = new HashMap<>();
		//리스트의 첫번째 VO를 꺼낸다
		OrderInfoVO orderInfoVO = list.pop();
		//첫번째 VO를 AlarmVO로 만든다
		OrderAlarmVO orderAlarmVO =orderInfoVO.toOrderAlarmVO();
		//("order_id"=AlarmVO) 형식으로 넣는다
		orderAndAlarm.put(orderInfoVO.getId(), orderAlarmVO);
		//(biz_id,("order_id"=AlarmVO) 로 넣는다
		bizAndOrder.put(orderInfoVO.getBizId(), orderAndAlarm);
		
		while(!list.isEmpty()) {
			//리스트에서 다음 VO를 꺼낸다
			orderInfoVO = list.pop();
			//새로 꺼낸 VO의 BizId와 일치하는 VO를 꺼내온다
			Map<String, OrderAlarmVO> innerMap= bizAndOrder.get(orderInfoVO.getBizId());
			//OrderAlarmVO innerAlarmVO = innerMap.get(orderInfoVO.getId());
			//일치하는 Map이 없었다면
			if(innerMap==null) {
				//OrderInfoVO로 새로운 OrderAlarmVO를 생성한다
				orderAlarmVO =orderInfoVO.toOrderAlarmVO();
				orderAndAlarm = new HashMap<>();
				orderAndAlarm.put(orderInfoVO.getId(), orderAlarmVO);
				//(biz_id,AlarmVO) 로 넣는다
				innerMap = new HashMap<String, OrderAlarmVO>();
				innerMap.put(orderInfoVO.getId(), orderAlarmVO);
				bizAndOrder.put(orderInfoVO.getBizId(), innerMap);
				continue;
			}
			//일치하는 VO가 있다면
			//맵에 있는 OrderAlarmVO의 menus에 optName만 추가한다
			OrderAlarmVO innerAlarmVO = innerMap.get(orderInfoVO.getId());
			innerAlarmVO.addMenu(orderInfoVO.toOrderAlarmMenuVO());
			//처리가 끝난 VO를 다시 (biz_id,AlarmVO) 로 넣는다
			innerMap.put(orderInfoVO.getId(),innerAlarmVO);
			bizAndOrder.put(orderInfoVO.getBizId(), innerMap);
		}
		
		
		return bizAndOrder;
		
	}
	
	
}
