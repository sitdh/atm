package com.sitdh.thesis.demo;

public class AutomaticTrollerMachine {
	
	private UserPool userPool;
	
	private CreditApprovement creditApprovement;
	
	public AutomaticTrollerMachine() {
		userPool = new UserPool();
		
		creditApprovement = new CreditApprovement();
	}
	
	public void informBalance(String user, double balance) {
		System.out.println("Hello, " + user);
		System.out.println("Your balance is " + String.valueOf(balance));
	}
	
	public User authentication(String userId, String pinNumber) {
		User user = this.userPool.queryUser(userId, pinNumber);
		return user;
	}

	public double getBalance(String userId, String pinNumber) throws Exception {
		
		User user = this.authentication(userId, pinNumber);
		if (null == user) { throw new Exception(); }
		
    	return user.getBalance();
    }

	public boolean withdraw(String userId, String pinNumber, double amount) {
		
		boolean isApproved = false;
		
		User user = this.authentication(userId, pinNumber);
		
		if (null != user) {
			if (user.getBalance() >= amount) {
				double updatedBalance = user.getBalance() - amount;
				this.updateUserBalance(userId, updatedBalance);
				isApproved = true;
			} else {
				boolean creditApprove = this.creditApprovement.approveCredit(user.getRating(), user.getOutlook(), user.getCredit());
				
				if (creditApprove) {
					double updatedBalance = user.getBalance() - amount;
					this.updateUserBalance(userId, updatedBalance);
					isApproved = true;
				}
			}
		}
		
		return isApproved;
	}
	
	private void updateUserBalance(String userId, double balance) {
		this.userPool.updateUserBalance(userId, balance);
	}
}
