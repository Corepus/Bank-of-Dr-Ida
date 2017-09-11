public class ATM {
 
    public static void main(String args[]) {
      
      boolean running = true;
      String input;
      
      Control.makeTitle();
      while(running) {
        
        input = Control.presentOptions();
        System.out.println("");
        if (input.equalsIgnoreCase("d")) {
         
          Control.depositMoney();
          
        } else if (input.equalsIgnoreCase("w")) {
          
          Control.withdrawlMoney();
          
        } else if (input.equalsIgnoreCase("m")) {

          Control.monthEnd();
          Control.printAll();
          
        } else if (input.equalsIgnoreCase("a")) {
          
         Control.addAccount(); 
          
        } else if (input.equalsIgnoreCase("q")) {
          
          System.out.println("Thank you for using the Bank of Dr Ida\n          Have a great day!");
          running = false;
          
        } else {
          System.out.println("Please enter a valid command");
          System.out.println();
          
        }
        
      }
      
    }
  
}
