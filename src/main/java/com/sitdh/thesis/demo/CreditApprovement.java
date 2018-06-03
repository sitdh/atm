package com.sitdh.thesis.demo;

public class CreditApprovement {

	public boolean approveCredit(DebtRating rating, Outlook outlook, double credit) {
		boolean allowance = false;
		
		if (credit > 0 
				&& this.outlookAllowance(outlook) 
				&& this.ratingAllowance(rating)) {
			
			allowance = true;
		}
		
		return allowance;
	}
	
	private boolean outlookAllowance(Outlook outlook) {
		
		boolean allowance = false;
		
		if (Outlook.POSITIVE == outlook || Outlook.STABLE == outlook) 
			allowance = true;
		
		
		return allowance;
	}
	
	private boolean ratingAllowance(DebtRating rating) {
		boolean allowance = false;
		
		if (DebtRating.B == rating || DebtRating.A == rating) 
			allowance = true;
		
		return allowance;
	}

}
