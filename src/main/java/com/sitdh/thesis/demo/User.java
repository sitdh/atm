package com.sitdh.thesis.demo;

public class User {

	private String userName;
	
	private String pinNo;
	
	private String userId;
	
	private DebtRating rating;
	
	private Outlook outlook;
	
	private boolean creditUser;
	
	private double balance;
	
	private double credit;
	
	public User(String username, 
			String userId, 
			String pinNo,
			DebtRating rating, 
			Outlook outlook,  
			double balance,
			double credit) {
		
		this.setUserId(username);
		this.setUserId(userId);
		this.setPinNo(pinNo);
		this.setRating(rating);
		this.setOutlook(outlook);
		this.setBalance(balance);
		this.setCredit(credit);
		
	}
	
	static UserBuilder builder() {
		return new UserBuilder();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPinNo() {
		return pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DebtRating getRating() {
		return rating;
	}

	public void setRating(DebtRating rating) {
		this.rating = rating;
	}

	public Outlook getOutlook() {
		return outlook;
	}

	public void setOutlook(Outlook outlook) {
		this.outlook = outlook;
	}

	public boolean isCreditUser() {
		return creditUser;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
		
		this.creditUser = this.credit > 0;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
		this.creditUser = this.credit > 0;
	}
	
}

class UserBuilder {
	
	private String userName;
	
	private String pinNo;
	
	private String userId;
	
	private DebtRating rating;
	
	private Outlook outlook;
	
	private double balance;
	
	private double credit;
	
	public UserBuilder userName(String userName) {
		this.userName = userName;
		
		return this;
	}
	
	public UserBuilder pinNo(String pinNo) {
		this.pinNo = pinNo;

		return this;
	}
	
	public UserBuilder userId(String userId) {
		this.userId = userId;

		return this;
	}
	
	public UserBuilder rating(DebtRating rating) {
		this.rating = rating;

		return this;
	}
	
	public UserBuilder outlook(Outlook outlook) {
		this.outlook = outlook;

		return this;
	}
	
	public UserBuilder balance(double balance) {
		this.balance = balance;
		
		return this;
	}
	
	public UserBuilder credit(double credit) {
		this.credit = credit;
		
		return this;
	}
	
	public User build() {
		return new User(this.userName, 
				this.userId, 
				this.pinNo,
				this.rating, 
				this.outlook,  
				this.balance,
				this.credit);
	}
}
