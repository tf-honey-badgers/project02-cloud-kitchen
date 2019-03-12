package org.badgers.rest.customer.review.service;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.badgers.rest.model.ReviewVO;

public interface ReviewService {
	public List<ReviewVO> revList();
	public List<RecommendedItem> recommendation(Long custIdx);
}
