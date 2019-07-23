package org.badgers.rest.customer.review.service;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.badgers.rest.model.GpaVOExtend;
import org.badgers.rest.model.MenuVOExtend;
import org.badgers.rest.model.ReviewVO;

public interface ReviewService {
	public List<ReviewVO> revList();
	public List<RecommendedItem> recommendation(Long custIdx);
	public List<GpaVOExtend> getGpa(String bizId);
	public List<MenuVOExtend> getRecommendMenu(String menuId);
}
