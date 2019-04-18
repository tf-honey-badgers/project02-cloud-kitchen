package org.badgers.rest.business.order.service;

import java.io.UnsupportedEncodingException;

import org.badgers.rest.firebase.FirebaseException;
import org.badgers.rest.firebase.FirebaseResponse;
import org.badgers.rest.firebase.JacksonUtilityException;

public interface BizFireBaseService {
	public FirebaseResponse patchOrderStatus(String key, String jsonData)throws FirebaseException, UnsupportedEncodingException, JacksonUtilityException;
	public String getToken(String orderId);

}
