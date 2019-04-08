package org.badgers.rest.favorite.controller;

import java.util.List;

import org.badgers.rest.favorite.service.FavoriteService;
import org.badgers.rest.model.FavoriteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

	@Setter(onMethod_ = { @Autowired })
	private FavoriteService service;
	
	// 찜  내역  보기 
	@CrossOrigin("http://localhost:3001")
	@GetMapping(value = "/{cust_id}/mypage", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<List<FavoriteVO>> readFavorites(@PathVariable("cust_id") String custId) {
		List<FavoriteVO> favorite = null;
		
		try {
			favorite = service.readFavorites(custId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<FavoriteVO>>(favorite, HttpStatus.OK);
	}
	
	// 찜 회수 읽기
	@GetMapping(value = "/{biz_id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<Integer> countFavorites(@PathVariable("biz_id") String bizId) {
		int favorite = 0;
		
		try {
			favorite = service.countFavorites(bizId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Integer>(favorite, HttpStatus.OK);
	}
	
	// 특정 고객(cust_id)이 특정 가게(biz_id)를 찜했는지 확인하기
	@GetMapping(value = "/{cust_id}/{biz_id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<Integer> isFavoriteChk(@PathVariable("cust_id") String custId, @PathVariable("biz_id") String bizId) {
		int favorite = 0;
		
		try {
			favorite = service.isFavoriteChk(custId, bizId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Integer>(favorite, HttpStatus.OK);
	}
	
	// 찜 추가하기
	@PostMapping(value = "/add", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<Integer> addFavorite(@RequestBody FavoriteVO fav) {
		int favorite = 0;
		
		try {
			favorite = service.addFavorite(fav);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Integer>(favorite, HttpStatus.OK);
	}
	
	// 찜 삭제하기
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/delete/{cust_id}/{biz_id}/{biz_like_cnt}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity deleteFavorite(
				@PathVariable("cust_id") String custId
				, @PathVariable("biz_id") String bizId
				, @PathVariable("biz_like_cnt") int bizLikeCnt
			) {
		try {
			service.deleteFavorite(custId, bizId, bizLikeCnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity(HttpStatus.OK);
	}
}