package org.badgers.rest.favorite.service;

import java.util.List;

import javax.inject.Inject;

import org.badgers.rest.favorite.persistence.FavoriteMapper;
import org.badgers.rest.model.FavoriteVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	// 특정 고객(cust_id)이 특정 가게(biz_id)를 찜했는지 확인하기
	@Override
	public int isFavoriteChk(String custId, String bizId) throws Exception {
		int favorite = mapper.isFavoriteChk(custId, bizId);
		return favorite;
	}
	
	// 가게 찜 추가하기
	@Override
	@Transactional
	public int addFavorite(FavoriteVO fav) throws Exception {
		int favorite = mapper.addFavorite(fav);
		fav.setBizLikeCnt(fav.getBizLikeCnt()+1);
		mapper.updateBizLikes(fav);
		return favorite;
	}
	
	// 찜 삭제하기
	@Override
	@Transactional
	public void deleteFavorite(String custId, String bizId, int bizLikeCnt) throws Exception {
		mapper.deleteFavorite(custId, bizId);
		FavoriteVO fav = new FavoriteVO();
		fav.setBizId(bizId);
		fav.setBizLikeCnt(bizLikeCnt-1);
		mapper.updateBizLikes(fav);
	}
}