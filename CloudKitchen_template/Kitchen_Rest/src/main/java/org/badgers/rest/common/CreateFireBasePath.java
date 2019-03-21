package org.badgers.rest.common;

import org.badgers.rest.model.OrderInfoVO;

public class CreateFireBasePath {
	public static StringBuffer getOrderPath(String key, OrderInfoVO vo) {
		StringBuffer path = new StringBuffer();

		path.append(vo.getBizId() + '/' + key + '/' + vo.getOrderdetailId() + '/')
				.append(vo.getOptName() != null ? vo.getOptName().replaceAll(" ", "") : "없음");

		return path;
	}
	
	public static StringBuffer getStatusPath(String key, OrderInfoVO vo) {
		StringBuffer path = new StringBuffer();

		path.append(vo.getBizId() + '/' + key + "/status");

		return path;
	}
	
	public static StringBuffer getStatusPath(String bizId, String key) {
		StringBuffer path = new StringBuffer();

		path.append(bizId + '/' + key + "/status");

		return path;
	}
}
