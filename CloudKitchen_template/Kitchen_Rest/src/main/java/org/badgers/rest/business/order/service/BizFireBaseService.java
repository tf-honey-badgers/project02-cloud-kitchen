package org.badgers.rest.business.order.service;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.badgers.rest.firebase.Firebase;
import org.badgers.rest.firebase.FirebaseException;
import org.badgers.rest.firebase.FirebaseResponse;
import org.badgers.rest.firebase.JacksonUtilityException;
import org.badgers.rest.firebasetest.Order;
import org.springframework.stereotype.Service;

@Service
public class BizFireBaseService {
	
	String firebase_baseUrl = "https://honeybadgers-d29cf.firebaseio.com/";
	
	public FirebaseResponse patchOrderStatus(StringBuffer key, String jsonData) throws FirebaseException, UnsupportedEncodingException, JacksonUtilityException {
		String firebase_baseUrl = this.firebase_baseUrl+key;
		Firebase firebase = new Firebase( firebase_baseUrl );
		FirebaseResponse response = firebase.patch(jsonData);
		
		return response;
	}
}
