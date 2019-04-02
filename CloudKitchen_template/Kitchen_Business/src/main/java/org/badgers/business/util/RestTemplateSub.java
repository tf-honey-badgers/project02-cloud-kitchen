package org.badgers.business.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

@Configuration
public class RestTemplateSub {
	@Bean
	public HttpComponentsClientHttpRequestFactory restTemplateBuilder() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(10000); // 읽기시간초과, ms
		factory.setConnectTimeout(3000); // 연결시간초과, ms
		HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(100) // connection pool 적용
				.setMaxConnPerRoute(5) // connection pool 적용
				.build();
		factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
		return factory;
	}
}