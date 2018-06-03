package com.sitdh.thesis.demo;

import java.util.ArrayList;
import java.util.List;

public class UserPool {

	private List<User> users;
	
	public UserPool() {
		users = new ArrayList<User>();
		this.createUserPool();
	}
	
	private void createUserPool() {
		// Alice
		User alice = User.builder()
				.userName("alice")
				.pinNo("1234")
				.userId("10000")
				.rating(DebtRating.A)
				.outlook(Outlook.POSITIVE)
				.balance(10000)
				.credit(70000)
				.build();
		
		User bob = User.builder()
				.userName("bob")
				.pinNo("5678")
				.userId("30001")
				.rating(DebtRating.B)
				.outlook(Outlook.STABLE)
				.balance(5000)
				.credit(1000)
				.build();
		
		// Craig
		User craig = User.builder()
				.userName("carol")
				.pinNo("4567")
				.userId("20002")
				.rating(DebtRating.D)
				.outlook(Outlook.NEGATIVE)
				.balance(1000)
				.credit(0)
				.build();
		
		this.users.add(alice);
		this.users.add(bob);
		this.users.add(craig);
	}

	public User queryUser(String userId, String pinNumber) {
		User user = null;
		
		for (User u : this.users) {
			if (u.getPinNo().equals(pinNumber) && u.getUserId().equals(userId)) {
				user = u;
				break;
			}
		}
		
		return user;
	}

	public void updateUserBalance(String userId, double balance) {
		
		for (int i = 0; i < this.users.size(); i++) {
			User u = this.users.get(i);
			if (u.getUserId().equals(userId)) {
				u.setBalance(balance);
				this.users.set(i, u);
				break;
			}
		}
		
	}
}
