package com.example.demo.model;

public class UserPaymentM {

	private String userName;
	private String cardNumber;
	private String expiryDate;
	private String userCvv;
	private String paid;
	private Integer userId;
	
	public UserPaymentM() {
		super();
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getUserCvv() {
		return userCvv;
	}
	public void setUserCvv(String userCvv) {
		this.userCvv = userCvv;
	}
	public String getPaid() {
		return paid;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
