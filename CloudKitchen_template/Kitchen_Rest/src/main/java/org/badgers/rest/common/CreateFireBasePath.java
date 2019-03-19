package org.badgers.rest.common;

import org.badgers.rest.model.OrderInfoVO;

public class CreateFireBasePath {
	public static StringBuffer[] getPath(String key, OrderInfoVO ov) {
		StringBuffer[] paths = { new StringBuffer(), new StringBuffer() };

		paths[0].append(ov.getBizId() + '/' + key + '/' + ov.getOrderdetailId() + '/')
				.append(ov.getOptName() != null ? ov.getOptName().replaceAll(" ", "") : "없음");

		paths[1].append(ov.getBizId() + '/' + key + "/status");

		return paths;
	}
}
