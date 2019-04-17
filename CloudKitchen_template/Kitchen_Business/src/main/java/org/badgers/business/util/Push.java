package org.badgers.business.util;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component(value="push")
public class Push  
{  

	String            endpoint;  
	List<String>      scope;  
	String            keyFile;  
	String            accessToken;  
	HttpURLConnection http;  
	StringBuffer      responseBody;  
  
	public Push() throws IOException  
	{  
	    this.endpoint = "https://fcm.googleapis.com/v1/projects/honeybadgers-d29cf/messages:send";  
		this.keyFile = "AAAAirDSVJU:APA91bELk-vmeH3kQD2YRm3zrpAueunhkJVop1pF3L-G4mTQtfeAANIhnRBW5-yUcYDpupZ2ByjjzQ4sCXCo0bPNOkehZszbe3eat_SFgpKHsbL8N7gzxcx0Y3lvJsvFMrZ9Ly8fewf3";  
	  
//		String tmp[] = System.getProperty("scope").split(",");  
//		this.scope = new ArrayList<>();  
//		for (String s : tmp)  
//		{  
//			this.scope.add(s);  
//	    }  
	  
		this.accessToken = AccessToken.getAccessToken();
		responseBody = new StringBuffer();  
	}  

	public String getEndpoint()  
	{  
		return endpoint;  
	}  
  
    public void setEndpoint(String endpoint)  
    {  
		this.endpoint = endpoint;  
	}  
  
	public String getAccessToken()  
	{  
		return accessToken;  
	}  
  
	public void setAccessToken(String accessToken)  
	{  
		this.accessToken = accessToken;  
	}  
  
	public StringBuffer getResponseBody()  
	{  
		return responseBody;  
	}  
  
	public String send(String userToken, String message) throws IOException  
	{  
		
		
		URL url = new URL(endpoint);  
		http = (HttpURLConnection) url.openConnection();  
  
		http.setRequestMethod("POST");  
		http.setDoInput(true);  
		http.setRequestProperty("Authorization", "Bearer " + accessToken);  
		System.out.println(accessToken);
		http.setRequestProperty("Content-Type", "application/json; UTF-8");  
  
		http.setDoOutput(true);  
		OutputStream os = http.getOutputStream();  

		String body =  
            "{\n" + "\"message\":{\n" + " \"notification\": {\n" + " \"title\": \"새로운 알림이 도착했습니다!\",\n"  
			+ " \"body\": \"" + message + "\",\n"  
			+ "  },\n" + " \"token\": \"" + userToken + "\"\n" + "  }\n" + "}\n";  
  
		  System.out.println(body);  
  
		os.write(body.getBytes());  
		os.flush();  
  
		os.close();  
  
		System.out.println("* CODE : " + http.getResponseCode());  
		System.out.println("* MSG  : " + http.getResponseMessage());  
  
		if(http.getResponseCode() == 200)  
		{  
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF8"));  
  
			String line;  
			while ((line = br.readLine()) != null)  
			{  
				responseBody.append(line);  
			}  
  
			br.close();  
		}  
  
		 http.disconnect();  
		return http.getResponseMessage();  
	}  
}



