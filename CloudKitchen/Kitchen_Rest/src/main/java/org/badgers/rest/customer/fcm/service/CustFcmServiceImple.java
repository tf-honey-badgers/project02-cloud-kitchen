package org.badgers.rest.customer.fcm.service;

import org.badgers.rest.customer.fcm.persistence.CustFcmMapper;
import org.badgers.rest.model.FcmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustFcmServiceImple implements CustFcmService  {
	
	@Autowired 
	private CustFcmMapper mapper;
	
	@Override
	public int updateFcmToken(FcmVO vo) {
		return mapper.updateFcmToken(vo);
	}

}
