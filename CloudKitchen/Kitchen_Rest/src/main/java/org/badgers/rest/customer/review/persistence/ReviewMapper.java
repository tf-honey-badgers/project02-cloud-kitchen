package org.badgers.rest.customer.review.persistence;

import java.util.List;

import org.badgers.rest.model.GpaVOExtend;
import org.badgers.rest.model.MenuVOExtend;
import org.badgers.rest.model.ReviewVO;

public interface ReviewMapper {
	public List<ReviewVO> revList();
	public List<GpaVOExtend> getGpa(String bizId);
	public MenuVOExtend getRecommendMenu(String menuId);
}
