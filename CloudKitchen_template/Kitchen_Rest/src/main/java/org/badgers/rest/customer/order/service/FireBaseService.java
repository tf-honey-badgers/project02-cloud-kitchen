package org.badgers.rest.customer.order.service;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.badgers.rest.customer.order.firebase.Firebase;
import org.badgers.rest.customer.order.firebase.FirebaseException;
import org.badgers.rest.customer.order.firebase.FirebaseResponse;
import org.badgers.rest.customer.order.firebase.JacksonUtilityException;
import org.badgers.rest.firebasetest.Order;
import org.springframework.stereotype.Service;

@Service
public class FireBaseService {
	
	public FirebaseResponse test(Map<String, Object> testmap) throws FirebaseException, UnsupportedEncodingException, JacksonUtilityException {
		
		// get the base-url (ie: 'http://gamma.firebase.com/username')
		String firebase_baseUrl = "https://honeybadgers-d29cf.firebaseio.com/";
		// get the api-key (ie: 'tR7u9Sqt39qQauLzXmRycXag18Z2')
		String firebase_apiKey = "AIzaSyDZ4Zt7FAQrf8ah4FDlGZU2-qLeinySOSs";

//		for( String s : args ) {
//
//			if( s == null || s.trim().isEmpty() ) continue;
//			String[] split = s.trim().split( "=" );
//
//			if( split[0].equals("baseUrl") ) {
//				firebase_baseUrl = split[1];
//			}
//			else if( split[0].equals("apiKey") ) {
//				firebase_apiKey = split[1];
//			}
//		}
		if( firebase_baseUrl == null || firebase_baseUrl.trim().isEmpty() ) {
			throw new IllegalArgumentException( "Program-argument 'baseUrl' not found but required" );
		}


		// create the firebase
		Firebase firebase = new Firebase( firebase_baseUrl );


		// "DELETE" (the fb4jDemo-root)
	//	FirebaseResponse response = firebase.delete();


		// "PUT" (test-map into the fb4jDemo-root)
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		//dataMap.put 에 String, String 넣으면 json 타입으로 해서 들어감 
//		dataMap.put( "orderInfo",testmap);
//		 response = firebase.put( dataMap );
//		System.out.println( "\n\nResult of PUT (for the test-PUT to fb4jDemo-root):\n" + response );
//		System.out.println("\n");
		
		// "PUT" (test-map into a sub-node off of the fb4jDemo-root)
//		dataMap = new LinkedHashMap<String, Object>();
//		dataMap.put("Key_1", "This is the first value");
//		dataMap.put("Key_2", "This is value #2");
//		
//		
//		Map<String, Object> dataMap2 = new LinkedHashMap<String, Object>();
//		dataMap2.put("Sub-Key1", "This is the first sub-value");
//		dataMap.put("Key_3", dataMap2);
//		response = firebase.put("test-PUT", dataMap);
//		System.out.println("\n\nResult of PUT (for the test-PUT):\n" + response);
//		System.out.println("\n");
		
		// "POST" (test-map into a sub-node off of the fb4jDemo-root)
//		 Map<String, Object> dataMap2 = new LinkedHashMap<String, Object>();
//		 dataMap2.put("order", testmap);
//		 
		 
		 FirebaseResponse response = firebase.post(testmap);
		System.out.println( "\n\nResult of POST (for the test-POST):\n" + response );
		System.out.println("\n");
		return response;
	}
	
	
	
	public FirebaseResponse getFirebase() throws FirebaseException, UnsupportedEncodingException {
		String firebase_baseUrl = "https://honeybadgers-d29cf.firebaseio.com/";
		Firebase firebase = new Firebase( firebase_baseUrl );
		FirebaseResponse response = firebase.get("-La0QQcQz3h8eNmgA7ws");
		
		
		return response;
		
	}
	
	
	

	
}
