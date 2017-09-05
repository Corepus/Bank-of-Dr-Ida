
public class CheckingAccount extends Account{

	private int withdrawls;
	
	public CheckingAccount(int accountNumber, int balance, int monthActive, int withdrawls) {
		
		super(accountNumber, balance, monthActive);
		this.withdrawls = withdrawls;
		
	}
	
	public int getWithdrawls() {
		
		return withdrawls;
		
	}
	
	public void setWithdrawls(int withdrawls) {
		
		this.withdrawls = withdrawls;
		
	}
	
}
