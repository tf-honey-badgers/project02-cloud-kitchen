package org.badgers.rest.business.order.service;

import java.io.UnsupportedEncodingException;

import org.badgers.rest.business.order.persistence.BizOrderMapper;
import org.badgers.rest.firebase.Firebase;
import org.badgers.rest.firebase.FirebaseException;
import org.badgers.rest.firebase.FirebaseResponse;
import org.badgers.rest.firebase.JacksonUtilityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BizFireBaseServiceImpl implements BizFireBaseService{
	@Autowired private BizOrderMapper mapper;
	final String firebase_baseUrl = "https://honeybadgers-d29cf.firebaseio.com/";
	//firebase 연결
	public FirebaseResponse patchOrderStatus(String key, String jsonData) throws FirebaseException, UnsupportedEncodingException, JacksonUtilityException {
		String firebase_baseUrl = this.firebase_baseUrl+key;
		Firebase firebase = new Firebase( firebase_baseUrl );
		FirebaseResponse response = firebase.patch(jsonData);
		
		return response;
	}
	
	//fcm 위한 토큰 가져오기 
	public String getToken(String orderId) {
		return mapper.getToken(orderId);
	}
}
