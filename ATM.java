import java.io.*;
import java.util.*;

public class ATM {
 
  public static void main(String args[]) {  
	Scanner scanner = new Scanner(System.in);
	int numericalInput;
	int balance;
	int accountNumber;
	String input;
	boolean savingAccount;
    boolean newAccount;
    int screen;
    boolean running = true;
    System.out.println("Welcome to the Bank of Dr.Ida");
    System.out.println("-------------------------------");
    screen = 0;
    while(running){
    	if (screen == 0) {
    		if (Account.promptNewAccount()) {
    			screen = 1;
    		} else {
    			screen = 2;
    		}
    	}
    	if (screen == 1) {
    		System.out.println("Write an account number:");
    		accountNumber = scanner.nextInt();
    		System.out.println("Write a balance:");
    		balance = scanner.nextInt();
    		System.out.println("Is this a S)avings or C)heckings account?");
    		input = scanner.next();
    		if (input.equalsIgnoreCase("s")) {
    			Account.addSavingAccount(accountNumber, balance, 0, balance);
    		} else {
    			Account.addCheckingsAccount(accountNumber, balance, 0, 3);
    		}
    		screen = 2;
    	}
    	if (screen == 2) {
    		System.out.println("D)eposit\nW)ithdrawl\nM)onth end\nN)ew Account\nQ)uit");
    		input = scanner.next();
    		if (input.equalsIgnoreCase("d")) {
    			System.out.println("What is your account number?");
    			accountNumber = scanner.nextInt();
    			System.out.println("How much would you like to deposit?");
    			balance = scanner.nextInt();
    			for (int i = 0; i < Account.accounts.length; i++) {
    				if (accountNumber == Account.accounts[i][1]) {
    					Account.accounts[i][2] += balance;
    					System.out.println(Account.accounts[i][2]);
    					break;
    				}
    			}
    		} else if (input.equalsIgnoreCase("w")) {
    			System.out.println("What is your account number?");
    			accountNumber = scanner.nextInt();
    			for (int i = 0; i < Account.accounts.length; i++) {
    				if (accountNumber == Account.accounts[i][1]) {
    					if (Account.accounts[i][0] == 0) {
    						System.out.println("How much would you like to withdrawl?");
    						balance = scanner.nextInt();
    						Account.accounts[i][2] -= balance;
    						System.out.println(Account.accounts[i][2]);
    						break;
    					} else {
    						if (Account.accounts[i][4] > 0) {
    							Account.accounts[i][4] -= 1;
    							System.out.println("How much would you like to withdrawl?");
        						balance = scanner.nextInt();
    							System.out.println("You have " + Account.accounts[i][4] + " withdrawls left");
    							Account.accounts[i][2] -= balance;
    							System.out.println(Account.accounts[i][2]);
    							break;
    						} else {
    							System.out.println("You have no transactions left, you must pay $1 for this withdrawl");
    							System.out.println("How much would you like to withdrawl?");
        						balance = scanner.nextInt();
    							Account.accounts[i][2] -= balance + 1;
    							System.out.println(Account.accounts[i][2]);
    							break;
    						}
    					}
    				}
    			}
    		} else if (input.equalsIgnoreCase("m")) {
    			for (int i = 0; i < Account.accounts.length; i++) {
    				if (Account.accounts[i][0] == 0) {
    					Account.accounts[i][2] = (int) (Account.accounts[i][2] * 0.03) + Account.accounts[i][2];
    					Account.accounts[i][4] = Account.accounts[i][2];
    				} else {
    					Account.accounts[i][4] = 3;
    				}
    				Account.accounts[i][3]++;
    				System.out.println("Account Number: " + Account.accounts[i][1] + " Balance: " + Account.accounts[i][2]);
    			}
    		} else if (input.equalsIgnoreCase("n")) {
    			screen = 1;
    		} else if (input.equalsIgnoreCase("q")) {
    			running = false;
    		}
    	}
    }
    
  }
  
}