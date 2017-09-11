
abstract class Account {
  
  private String name;
  private int accountNumber;
  private double balance;

  public Account(String name, int accountNumber, double balance) {
    
    this.name = name;
    this.accountNumber = accountNumber;
    this.balance = balance;
    
  }
  
  public String getName() {
    
    return name;
    
  }
  
  public int getAccountNumber() {
    
    return accountNumber;
    
  }
  
  public double getBalance() {
    
    balance = Math.round(balance * 100);
    balance = balance / 100;
    return balance;
    
  }
  
  public void setBalance(double balance) {
    
    this.balance = balance;
    
  }

}