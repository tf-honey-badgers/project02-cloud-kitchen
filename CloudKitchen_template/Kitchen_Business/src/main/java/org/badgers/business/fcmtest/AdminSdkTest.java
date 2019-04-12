package org.badgers.business.fcmtest;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import lombok.extern.log4j.Log4j;
@Log4j
@Component
public class AdminSdkTest {
	public static void main(String[] args) throws IOException {
		 AdminSdkTest ad = new AdminSdkTest() ;
		 String result =ad.getAccessToken();
		 log.info(result);
		 
	}

	@Autowired
	private  ResourceLoader resourceLoader;

	private  InputStream getInputStreamFirebaseKeyFile() {
		log.info(".....................................1                     .........");
		InputStream inputStreamFirebaseKeyFile = null;
		try {
			Resource resource = resourceLoader.getResource("classpath:config/honeybadgers-d29cf-firebase-adminsdk-50gtz-6f64e8fc65.json");
			inputStreamFirebaseKeyFile = resource.getInputStream();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return inputStreamFirebaseKeyFile;
	}
	public DatabaseReference databaseReference() {
		log.info(".....................................2                     .........");
		DatabaseReference databaseReference = null;
		
		try {
			FirebaseOptions firebaseOptions = FirebaseOptions
					.builder()
					.setCredentials(ServiceAccountCredentials.fromStream(getInputStreamFirebaseKeyFile()))
					.setDatabaseUrl("https://honeybadgers-d29cf.firebaseio.com/")
					.build();
			databaseReference = FirebaseDatabase.getInstance(FirebaseApp.initializeApp(firebaseOptions)).getReference();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return databaseReference;
	}
	public String getAccessToken() throws IOException {
		FirebaseOptions firebaseOptions = FirebaseOptions
				.builder()
				.setCredentials(ServiceAccountCredentials.fromStream(getInputStreamFirebaseKeyFile()))
				.setDatabaseUrl("https://honeybadgers-d29cf.firebaseio.com/")
				.build();
		FirebaseApp.initializeApp(firebaseOptions);
		  GoogleCredential googleCredential = GoogleCredential
		      .fromStream(getInputStreamFirebaseKeyFile());
//		      .createScoped(Arrays.asList(SCOPES));
		  googleCredential.refreshToken();
		  return googleCredential.getAccessToken();
	}
	
	

}
