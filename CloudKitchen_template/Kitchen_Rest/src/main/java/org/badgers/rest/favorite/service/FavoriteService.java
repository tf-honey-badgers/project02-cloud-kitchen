package org.badgers.rest.favorite.service;

import java.util.List;

import org.badgers.rest.model.FavoriteVO;

public interface FavoriteService {
	// 찜 내역 보기 
	public List<FavoriteVO> readFavorites(String custId) throws Exception;

	// 가게 찜 회수 구하기
	public int countFavorites(String bizId) throws Exception;
	
	// 특정 고객(cust_id)이 특정 가게(biz_id)를 찜했는지 확인하기
	public int isFavoriteChk(String custId, String bizId) throws Exception;
	
	// 가게 찜 추가하기
	public int addFavorite(FavoriteVO fav) throws Exception;
	
	// 찜 삭제하기
	public void deleteFavorite(String custId, String bizId, int bizLikeCnt) throws Exception;
}
