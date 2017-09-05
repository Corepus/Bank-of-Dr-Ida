
public class SavingAccount extends Account {
	 
	  private double interest;
	  private int monthlyMinimumBalance;
	  
	  public SavingAccount(int accountNumber, int balance, int monthActive, double interest, int monthlyMinimumBalance) {
		  super(accountNumber, balance, monthActive);
		  this.interest = interest;
		  this.monthlyMinimumBalance = monthlyMinimumBalance;
	  }
	  
	  public void setMonthlyMinimumBalance(int monthlyMinimumBalance) {
		  this.monthlyMinimumBalance = monthlyMinimumBalance;
	  }
	  
	  public int getIntrest() {
		  return (int) (monthlyMinimumBalance * interest);
	  }
	  
	}