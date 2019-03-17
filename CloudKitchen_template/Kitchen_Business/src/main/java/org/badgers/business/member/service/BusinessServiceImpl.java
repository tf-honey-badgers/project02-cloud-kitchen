package org.badgers.business.member.service;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BusinessServiceImpl {
	public static void main(String[] args) {
		
		System.out.println("started.........");
		
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

		// HttpClient객체는 커넥션풀을 기본으로 쓰지 않기 때문에 Route와 연결수를 지정해서 DBCP처럼 유지시켜줘야함
		HttpClient httpClient = HttpClientBuilder.create().setMaxConnPerRoute(5).build();
		factory.setHttpClient(httpClient);
		
		//해당 정보를 바탕으로 restTemplate을 만듬
		RestTemplate restTemplate = new RestTemplate(factory);
		System.out.println("restTemplate is : " + restTemplate);
		
		try {
			String url = "http://localhost/business/biz_1/mypage";
			System.out.println("here I am");
			ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
			System.out.println("here I am");
			
			List<?> bizMember = responseEntity.getBody();

			System.out.println(responseEntity);
			System.out.println(bizMember);

			for(int i = 0; i < bizMember.size(); i++) {
				System.out.println(bizMember.get(i));
			}

		}catch(Exception e){
			e.getStackTrace();
		}
	}
}
