package org.badgers.business.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

public class AccessToken {
	
	  public static String getAccessToken() throws IOException  
	   {  
		 
	      InputStream resourceAsStream = AccessToken.class  
	  .getResourceAsStream("/config/" + "honeybadgers-d29cf-firebase-adminsdk-50gtz-6f64e8fc65.json");  
	      
		  GoogleCredential googleCredential = GoogleCredential  
	            .fromStream(resourceAsStream)  
	            .createScoped(Arrays.asList("https://www.googleapis.com/auth/firebase", 
	            		"https://www.googleapis.com/auth/cloud-platform", 
	            		"https://www.googleapis.com/auth/firebase.readonly"));  
	  
		  googleCredential.refreshToken();  
	  
		 return googleCredential.getAccessToken();  
	  }  

}
