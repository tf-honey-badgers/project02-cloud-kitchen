package org.badgers.rest.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.badgers.rest.model.OrderAlarmVO;
import org.badgers.rest.model.OrderInfoVO;

public class ToOrderAlarmVO {

	
	public static Map<String, OrderAlarmVO> toOrderAlarmVO(LinkedList<OrderInfoVO> list) {
		
		Map<String, OrderAlarmVO> map = new HashMap<>();
		
		//리스트의 첫번째 VO를 꺼낸다
		OrderInfoVO orderInfoVO = list.pop();
		//첫번째 VO를 AlarmVO로 만든다
		OrderAlarmVO orderAlarmVO =orderInfoVO.toOrderAlarmVO();
		//(biz_id,AlarmVO) 로 넣는다
		map.put(orderInfoVO.getBizId(), orderAlarmVO);
		
		while(!list.isEmpty()) {
			//리스트에서 다음 VO를 꺼낸다
			orderInfoVO = list.pop();
			//새로 꺼낸 VO의 BizId와 일치하는 VO를 꺼내온다
			OrderAlarmVO innerAlarmVO= map.get(orderInfoVO.getBizId());
			//일치하는 VO가 없었다면
			if(innerAlarmVO==null) {
				//OrderInfoVO로 새로운 OrderAlarmVO를 생성한다
				orderAlarmVO =orderInfoVO.toOrderAlarmVO();
				//(biz_id,AlarmVO) 로 넣는다
				map.put(orderInfoVO.getBizId(), orderAlarmVO);
				continue;
			}
			//일치하는 VO가 있다면
			//맵에 있는 OrderAlarmVO의 menus에 optName만 추가한다
			innerAlarmVO.addMenu(orderInfoVO.toOrderAlarmMenuVO());
			//처리가 끝난 VO를 다시 (biz_id,AlarmVO) 로 넣는다
			map.put(orderInfoVO.getBizId(), innerAlarmVO);
		}
		return map;
	}
	
}
