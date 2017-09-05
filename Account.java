import java.util.Scanner;

public abstract class Account {
  
  private final int accountNumber;
  private int balance;
  private int monthActive;
  private static boolean flag = true;
  public static int[][] accounts= new int[1][5]; 
  private static int[][] temp;
  static String input;
  static Scanner scanner = new Scanner(System.in);
  
  public Account(int accountNumber, int balance, int monthActive) { 
    this.accountNumber = accountNumber;
    this.balance = balance;   
    this.monthActive = monthActive;
  }
  
  public final int getAccountNumber() {
    return accountNumber;
  }
  
  public int getBalance() {
   return balance; 
  }
  
  public void setBalance(int balance) {
    this.balance = balance;
  }
  
  public void setMonthActive(int monthActive) {
   this.monthActive = monthActive; 
  }
  
  public static boolean promptNewAccount() {
	  
	  System.out.println("Are you using a new or existing account");
	  System.out.println("N)ew"
	    		+ "\nE)xisting");
	  input = scanner.next();
	  if (input.equalsIgnoreCase("n")) {
		  return true;
	  } else if (input.equalsIgnoreCase("e")) {
		  return false;
	  } else {
		  return false;
	  }
	  
  }
  
  public static void addSavingAccount(int accountNumber, int balance, int monthActive, int minimumMonthlyBalance) {
	  if (flag) {
		  accounts[0][0] = 0;
		  accounts[0][1] = accountNumber;
		  accounts[0][2] = balance;
		  accounts[0][3] = monthActive;
		  accounts[0][4] = minimumMonthlyBalance;
		  flag = false;
		  
	  } else {
		temp = new int[accounts.length + 1][accounts[0].length];
	  	for (int i = 0; i < accounts.length; i++) {
		  	for (int j = 0; j < accounts[0].length; j++) {
			  	temp[i][j] = accounts[i][j];
			  	System.out.println(accounts[i][j]);
		  	}
	  	}
	  	temp[temp.length - 1][0] = 0;
	  	temp[temp.length - 1][1] = accountNumber;
	  	temp[temp.length - 1][2] = balance;
	  	temp[temp.length - 1][3] = monthActive;
	  	temp[temp.length - 1][4] = minimumMonthlyBalance;
	  	accounts = temp;
	  }
  }
  
  public static void addCheckingsAccount(int accountNumber, int balance, int monthActive, int withdrawls) {
	  
	  if (flag) {
		  accounts[0][0] = 1;
		  accounts[0][1] = accountNumber;
		  accounts[0][2] = balance;
		  accounts[0][3] = monthActive;
		  accounts[0][4] = withdrawls;
		  flag = false;
	  } else {
		temp = new int[accounts.length + 1][accounts[0].length];
	  	for (int i = 0; i < accounts.length; i++) {
		  	for (int j = 0; j < accounts[0].length; j++) {
			  	temp[i][j] = accounts[i][j];
		  	}
	  	}
	  	temp[temp.length - 1][0] = 0;
	  	temp[temp.length - 1][1] = accountNumber;
	  	temp[temp.length - 1][2] = balance;
	  	temp[temp.length - 1][3] = monthActive;
	  	temp[temp.length - 1][4] = withdrawls;
	  	accounts = temp;
	  }
  }
  
}