package org.badgers.rest.favorite.service;

import java.util.List;

import javax.inject.Inject;

import org.badgers.rest.favorite.persistence.FavoriteMapper;
import org.badgers.rest.model.FavoriteVO;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Inject
	private FavoriteMapper mapper;
	
	//찜정보
	@Override
	public List<FavoriteVO> readFavorites(String custId) throws Exception {
		List<FavoriteVO> favorite = mapper.readFavorites(custId);

		return favorite;
	}
	

	// 가게 찜 회수 구하기
	@Override
	public int countFavorites(String bizId) throws Exception {
		int favorite = mapper.countFavorites(bizId);
		
		return favorite;
	}
	
	// 가게 찜 추가하기
	@Override
	public int addFavorite(FavoriteVO fav) throws Exception {
		int favorite = mapper.addFavorite(fav);
		
		return favorite;
	}
	
	// 찜 삭제하기
	@Override
	public int deleteFavorite(String custId, String bizId) throws Exception {
		int favorite = mapper.deleteFavorite(custId, bizId);
		
		return favorite;
	}
}