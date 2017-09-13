import java.util.*;

abstract class Control {
  
  static Scanner scanner = new Scanner(System.in);
  static ArrayList<Account> accountList = new ArrayList<Account>();
  static SavingsAccount temporarySavingsAccount;
  static CheckingsAccount temporaryCheckingsAccount;
  static Account temporaryAccount;
  
  static boolean firstAccount = true;
  static String input;
  static String name;
  static int accountNumber;
  static int withdrawlsLeft;
  static double balance;
  static boolean savingsAccount;
  static boolean accountFound = false;
  
  public static void makeTitle() {
   
    System.out.println("Welcome to the Bank of Dr Ida");
    System.out.println("------------------------------");
    
  }
  
  public static String presentOptions() {
    
    System.out.println("D)eposit\nW)ithdrawl\nM)onth End\nA)dd Account\nQ)uit");
    System.out.println("");
    return scanner.next();
    
  }
  
  public static void addAccount() {
   
    System.out.println("S)avings Account\nC)heckings Account");
    System.out.println("");
    input = scanner.next();
    System.out.println("");
    
    if (input.equalsIgnoreCase("s")) {
      
      System.out.println("What is your name?");
      System.out.println("");
      name = scanner.next();
      System.out.println("");
      
      System.out.println("What is the account number?");
      System.out.println("");
      accountNumber = scanner.nextInt();
      if(firstAccount) {
    	  firstAccount = false;
    	  
    	  System.out.println("What is your current balance?");
          System.out.println("");
          balance = scanner.nextDouble();
          System.out.println("");
          
          SavingsAccount savingsAccount = new SavingsAccount(name, accountNumber, balance);
          accountList.add(savingsAccount);
      } else {
    	  if(isDuplicate(accountNumber)) {
    		  System.out.println("");
    		  System.out.println("That account number is already taken");
    	  } else {
    		  System.out.println("What is your current balance?");
    	      System.out.println("");
    	      balance = scanner.nextDouble();
    	      System.out.println("");
    	      
    	      SavingsAccount savingsAccount = new SavingsAccount(name, accountNumber, balance);
    	      accountList.add(savingsAccount);
    	  }
    	  
    	  System.out.println("");
    	  
      }
    }
      
     else if (input.equalsIgnoreCase("c")) {
      
      System.out.println("What is your name?");
      System.out.println("");
      name = scanner.next();
      System.out.println("");
      
      System.out.println("What is the account number?");
      System.out.println("");
      accountNumber = scanner.nextInt();
      if(firstAccount) {
    	  firstAccount = false;
    	  
    	  System.out.println("What is your current balance?");
          System.out.println("");
          balance = scanner.nextDouble();
          System.out.println("");
          
          CheckingsAccount checkingsAccount = new CheckingsAccount(name, accountNumber, balance, 3);
          accountList.add(checkingsAccount);
      } else {
    	  if(isDuplicate(accountNumber)) {
    		  System.out.println("");
    		  System.out.println("That account number is already taken");
    	  } else {
    		  System.out.println("What is your current balance?");
    	      System.out.println("");
    	      balance = scanner.nextDouble();
    	      System.out.println("");
    	      
    	      CheckingsAccount checkingsAccount = new CheckingsAccount(name, accountNumber, balance, 3);
    	      accountList.add(checkingsAccount);
    	  }
    	  
    	  System.out.println("");
    	  
      }
    } else {
     
      System.out.println("Please input a valid option");
      System.out.println("");
      
    }
    
  }
  
  public static void depositMoney() {
    
    System.out.println("What is your account number?");
    System.out.println("");
    accountNumber = scanner.nextInt();
    System.out.println("");
    
    for (int i = 0; i < accountList.size(); i++) {
      
      temporaryAccount = accountList.get(i);
      
      if (temporaryAccount.getAccountNumber() == accountNumber) {
        
    	accountFound = true;  
    	System.out.println("How much money would you like to add?");
        System.out.println("");
        balance = scanner.nextDouble();
        System.out.println("");
        
        temporaryAccount.setBalance(temporaryAccount.getBalance() + balance);
        accountList.set(i, temporaryAccount);
        System.out.println("Balance: $" + temporaryAccount.getBalance());
        System.out.println("");
        break;
      
      }
    }
    
    if (!accountFound) {
    	
    	System.out.println("Please input a valid account number");
    	System.out.println("");
    	
    } else {
    	
    	accountFound = false;
    	
    }
    
  }
  
  public static void withdrawlMoney() {
    
    System.out.println("What is your account number?");
    System.out.println("");
    accountNumber = scanner.nextInt();
    System.out.println("");
    
    for (int i = 0; i < accountList.size(); i++) {
      
      temporaryAccount = accountList.get(i);
      
      if (temporaryAccount.getAccountNumber() == accountNumber) {
        
        if (temporaryAccount.getClass().equals(SavingsAccount.class)) {
          
          System.out.println("How much money would you like to take out?");
          System.out.println("");
          balance = scanner.nextDouble();
          System.out.println("");
          
          temporaryAccount.setBalance(temporaryAccount.getBalance() - balance);
          
          temporarySavingsAccount = (SavingsAccount) (temporaryAccount);
          
          if(temporarySavingsAccount.getBalance() < temporarySavingsAccount.getMinimumMonthlyBalance()) {
            
           temporarySavingsAccount.setMinimumMonthlyBalance (temporarySavingsAccount.getBalance());
          
          }
          accountList.set(i, temporarySavingsAccount);
          System.out.println("Balance: $" + temporarySavingsAccount.getBalance());
          System.out.println("");
          break;
          
        } else {
          
          temporaryCheckingsAccount = (CheckingsAccount) (temporaryAccount);
          
          System.out.println("You have " + temporaryCheckingsAccount.getWithdrawlsLeft() + " withdrawls");
          
          if(temporaryCheckingsAccount.getWithdrawlsLeft() == 0) {
            
            System.out.println("You need to pay $1 to withdrawl money\nContinue?\nY)es\nN)o\n");
            input = scanner.next();
            
            if (input.equalsIgnoreCase("y")) {
              
              temporaryCheckingsAccount.setBalance(temporaryCheckingsAccount.getBalance() - 1);
              System.out.println("");
              System.out.println("How much money would you like to take out?");
              System.out.println("");
              balance = scanner.nextDouble();
              System.out.println("");
              
              temporaryCheckingsAccount.setBalance(temporaryCheckingsAccount.getBalance() - balance);
              accountList.set(i, temporaryCheckingsAccount);
              System.out.println("Balance: $" + temporaryAccount.getBalance());
              System.out.println("");
              break;
              
            } else {
              
              System.out.println("");
              break;
              
            }
            
          } else {
            
            temporaryCheckingsAccount.setWithdrawlsLeft(temporaryCheckingsAccount.getWithdrawlsLeft() - 1);
            System.out.println("");
            System.out.println("How much money would you like to take out?");
            System.out.println("");
            balance = scanner.nextDouble();
            System.out.println("");
              
            temporaryCheckingsAccount.setBalance(temporaryCheckingsAccount.getBalance() - balance);
            accountList.set(i, temporaryCheckingsAccount);
            System.out.println("Balance: $" + temporaryAccount.getBalance());
            System.out.println("You have " + temporaryCheckingsAccount.getWithdrawlsLeft() + " withdrawl(s) left");

            System.out.println("");
            
          }
        
        }
        
        
      }
      
    }
    
  }
  
  public static void monthEnd() {
    
    for(Account account : accountList) {
      
      if(account.getClass().equals(SavingsAccount.class)) {
       
        temporarySavingsAccount = (SavingsAccount) (account);
        temporarySavingsAccount.setInterest();
        temporarySavingsAccount.setMinimumMonthlyBalance(temporarySavingsAccount.getBalance());
      
      } else {
        
        temporaryCheckingsAccount = (CheckingsAccount) (account);
        temporaryCheckingsAccount.setWithdrawlsLeft(3);
 
      }
      
    }
    
  }
  
  public static void printAll() {
    
    for (Account account : accountList) {
     
      if (account.getClass().equals(SavingsAccount.class)) {
        
        System.out.println("Savings Account");
        
      } else {
        
        System.out.println("Checkings Account");
        
      }
      System.out.println("Name: " + account.getName());
      System.out.println("Account number: " + account.getAccountNumber());
      System.out.println("Balance: $" + account.getBalance());
      System.out.println("");
      
    }
    
  }
  
  public static boolean isDuplicate(int accountNumber) {
	  
	  boolean flag = false;
	  
	  for(int i = 0; i < accountList.size(); i++) {
		  
		  temporaryAccount = accountList.get(i);
		 
		  if (accountNumber == temporaryAccount.getAccountNumber()) {
			  flag = true;
			  break;
		  } 
	  }
	  return flag;
  }
    
}