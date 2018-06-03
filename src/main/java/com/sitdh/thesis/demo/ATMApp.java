package com.sitdh.thesis.demo;

public class ATMApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutomaticTrollerMachine atm = new AutomaticTrollerMachine();
		
		atm.withdraw("1000", "1234", 300);
		
		atm.withdraw("20002", "4567", 2000);
	}

}
