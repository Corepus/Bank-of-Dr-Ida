
public class SavingsAccount extends Account{
	  
	private double minimumMonthlyBalance;

	public SavingsAccount(String name, int accountNumber, double balance) {
	    
	  super(name, accountNumber, balance);
	  this.minimumMonthlyBalance = balance;
	    
	}	  
	  
	public double getMinimumMonthlyBalance() {
	    
	  return minimumMonthlyBalance;
	    
	}
	  
	public void setMinimumMonthlyBalance(double minimumMonthlyBalance) {
	    
	  this.minimumMonthlyBalance = minimumMonthlyBalance;
	    
	}
	  
	public void setInterest() {
	    
	  double interest = minimumMonthlyBalance * 0.03;
	  interest = Math.round(interest * 100);
	  interest = interest / 100;
	  super.setBalance(super.getBalance() + interest);
	    
	}
	
}