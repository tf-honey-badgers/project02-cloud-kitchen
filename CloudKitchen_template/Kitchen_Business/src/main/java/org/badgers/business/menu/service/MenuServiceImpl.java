package org.badgers.business.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Setter(onMethod_=@Autowired)
	private RestTemplate restTemplate;
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<?> bizGetMenu(String bizId) {
		
		try {
			String url = "http://localhost:80";
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"rest/kitchenbranch/bizinfo/"+bizId, List.class);
			
			List<?> menuVoEx = menuResponseEntity.getBody();
			return menuVoEx;

		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<?> getMenuInfo(int mIdx) {
		
		try {
			String url = "http://localhost:80";
			ResponseEntity<List> menuResponseEntity = restTemplate.getForEntity
					(url+"rest/kitchenbranch/menuinfo/"+mIdx, List.class);
			
			List<?> menuOptVoEx = menuResponseEntity.getBody();
			return menuOptVoEx;

		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}
	}

