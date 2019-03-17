package org.badgers.rest.customer.order.firebase;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.InputStream;

@Configuration
public class FirebaseConfiguration {

	@Autowired
	ResourceLoader resourceLoader;

	@Bean
	public InputStream getInputStreamFirebaseKeyFile() {
		InputStream inputStreamFirebaseKeyFile = null;
		try {
			Resource resource = resourceLoader.getResource("classpath:config/honeybadgers-d29cf-firebase-adminsdk-50gtz-6f64e8fc65.json");
			inputStreamFirebaseKeyFile = resource.getInputStream();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return inputStreamFirebaseKeyFile;
	}

	@Bean
	public DatabaseReference databaseReference() {
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

}

	
	
	


