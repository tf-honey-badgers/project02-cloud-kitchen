package org.badgers.rest.customer.review.service;

import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

//@Service
public class ReviewServiceImpl implements ReviewService {
	
	public static void main(String[] args) throws TasteException {
		
		
	}

//	public static void main(String[] args) throws TasteException {
//		MysqlDataSource dbsource = new MysqlDataSource();
//		
//		// 해당 DB로 접근
//		dbsource.setUser("bit");
//		dbsource.setPassword("bit");
//		dbsource.setServerName("mysql.cncdtmz2goi0.ap-northeast-2.rds.amazonaws.com");
//		dbsource.setDatabaseName("honey_badgers");
//		
//		// 접속할DB정보가 담긴 객체, table이름, 유저ID, 메뉴ID, 선호도 순서
//		JDBCDataModel dm = new MySQLJDBCDataModel(dbsource, "review", "cust_idx", "menu_id", "stars", "");
//		
//		// 유저 기반으로 비슷한유저를 찾음
//		UserSimilarity similarity = new PearsonCorrelationSimilarity(dm);
//		// 해당 유저들을 그룹으로 묶음, 생성자의 매개변수(정밀도, 유저, 접속하게 될 DB정보)
//		UserNeighborhood neighbor = new ThresholdUserNeighborhood(0.1, similarity, dm);
//		// 추천기 생성자(DB정보, 그룹군, 비슷한유저)
//		Recommender recommender = new GenericUserBasedRecommender(dm, neighbor, similarity);
//		// 추천기를 돌리면 recommend(추천받을 유저id,추천해주는 메뉴id)
//		List<RecommendedItem> list = recommender.recommend(4, 1);
//		
//		System.out.println(list);
//	}
}
