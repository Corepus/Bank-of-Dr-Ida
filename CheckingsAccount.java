
public class CheckingsAccount extends Account{
	  
	private int withdrawlsLeft;
	  
	public CheckingsAccount(String name, int accountNumber, double balance, int withdrawlsLeft) {
	    
	  super(name, accountNumber, balance);
	  this.withdrawlsLeft = withdrawlsLeft;
	        
	}
	  
	public int getWithdrawlsLeft() {
	    
	  return withdrawlsLeft;
	    
	}
	  
	public void setWithdrawlsLeft(int withdrawlsLeft) {
	    
		this.withdrawlsLeft = withdrawlsLeft;
	    
	}

}