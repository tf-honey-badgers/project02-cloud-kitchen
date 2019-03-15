package org.badgers.rest.customer.review.controller;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.badgers.rest.customer.review.service.ReviewServiceImpl;
import org.badgers.rest.model.GpaVOExtend;
import org.badgers.rest.model.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Setter(onMethod_ = {@Autowired})
	private ReviewServiceImpl service;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<ReviewVO> revList(){
		System.out.println("리뷰 리스트 컨트롤러");
		return service.revList();
	}
	
	@RequestMapping("/recommendation")
	@ResponseBody
	public List<RecommendedItem> recommendation(@RequestParam("idx") Long cust_idx){
		return service.recommendation(cust_idx);
	}
	
	@RequestMapping("/gpa")
	@ResponseBody
	public List<GpaVOExtend> getGpa(@RequestParam("gpa") String bizId){
		return service.getGpa(bizId);
	}
}
