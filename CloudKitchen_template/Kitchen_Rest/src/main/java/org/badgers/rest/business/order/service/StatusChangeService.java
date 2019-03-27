package org.badgers.rest.business.order.service;

import org.springframework.stereotype.Service;

@Service
public class StatusChangeService {
	
	public enum Code {
		ORD001("ORD001","주문 대기 상태"),
		ORD002("ORD002","주문 접수 상태"),
		ORD003("ORD003","조리 중 상태"),
		ORD004("ORD004","조리 완료 상태"),
		ORD005("ORD005","주문 취소 상태"),
		ORD006("ORD006","주문 거부 상태"),
		ORD007("ORD007","주문 부분접수 상태");
		
		private String statusCode;
		private String statusName;
		
		Code(String statusCode, String status){
			this.statusCode = statusCode;
			this.statusName = status;
		}
		
		public String getStatusCode() {
			return statusCode;
		}
		
		public String getStatusName() {
			return statusName;
		}
	}
	
	public String getNewStatus(String status) {
		
		
		return "{\"status\":\""+Code.valueOf(status).getStatusName()+"\", \"statusCode\":\""+status+"\"}";
	}
}
