package org.badgers.rest.favorite.persistence;

import java.util.List;

import org.badgers.rest.model.FavoriteVO;

public interface FavoriteMapper {
	// 찜 내역 보기 
	public List<FavoriteVO> readFavorites(String custId) throws Exception;
	
	// 가게 찜 회수 구하기
	public int countFavorites(String bizId) throws Exception;
	
	// 찜 추가하기
	public int addFavorite(FavoriteVO fav) throws Exception;
	
	// 찜 삭제하기
	public int deleteFavorite(String custId, String bizId) throws Exception;
}
