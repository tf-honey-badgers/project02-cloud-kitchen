package org.badgers.business.order.controller;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.badgers.business.model.OrderVO;
import org.badgers.business.model.OrderVOExtend;
import org.badgers.business.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;

@RequestMapping("/order")
@Controller
public class OrderController {

	@Setter(onMethod_ = { @Autowired })
	private OrderService service;

	@GetMapping("test/yuni")
	public String test(OrderVO vo) {

	

		return "yuni";
	}
	
	@PostMapping("test/yuni")
	public String test2(@RequestBody OrderVOExtend vo) {
		
		System.out.println(vo);

		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(5000); // 읽기시간초과, ms
		factory.setConnectTimeout(3000); // 연결시간초과, ms
		HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(100) // connection pool 적용
				.setMaxConnPerRoute(5) // connection pool 적용
				.build();
		factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
		RestTemplate restTemplate = new RestTemplate(factory);
		String url = "http://127.0.0.1:3000/controller/rest/cust/order/restTemplateTest3"; // 예제니까 애초에 때려박음..
		Object obj = restTemplate.postForObject(url,vo, OrderVOExtend.class );
		System.out.println(obj);

		return "yuni";
	}

}
