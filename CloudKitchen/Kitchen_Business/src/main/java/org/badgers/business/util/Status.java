package org.badgers.business.util;

public enum Status {
	ORD001("ORD001","주문 대기 상태",""),
	ORD002("ORD002","주문 접수 상태","주문 접수가 완료되었습니다."),
	ORD003("ORD003","조리 중 상태","요리가 시작되었습니다."),
	ORD004("ORD004","조리 완료 상태",""),
	ORD005("ORD005","주문 취소 상태","가게 사정으로 주문이 취소되었습니다. 죄송합니다."),
	ORD006("ORD006","주문 거부 상태",""),
	ORD007("ORD007","주문 부분접수 상태","");
	
	private String statusCode;
	private String statusName;
	private String message;
	
	Status(String statusCode, String status, String message){
		this.statusCode = statusCode;
		this.statusName = status;
		this.message=message;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	
	public String getStatusName() {
		return statusName;
	}
	
	public String getmessage() {
		return message;
	}
}