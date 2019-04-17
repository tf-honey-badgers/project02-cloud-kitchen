package org.badgers.rest.customer.fcm.service;

import org.badgers.rest.model.FcmVO;
import org.springframework.stereotype.Service;

public interface CustFcmService {
	public int updateFcmToken(FcmVO vo);

}
