package org.badgers.business.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;

@Service
public class MenuServiceImpl implements MenuService {
	
	
	@Override
	public List<?> bizGetMenu(String bizId) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			String url = "http://localhost:80/";
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"kitchenbranch/bizinfo/"+bizId, List.class);
			
			List<?> menuVoEx = menuResponseEntity.getBody();
			return menuVoEx;

		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	
	
}
