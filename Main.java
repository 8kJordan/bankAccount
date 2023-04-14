package abstractClass;
import java.util.*;

public class Main {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		createAccount();
		mainMenu();
		
	}// end main method

	
	
	public static void createAccount() {
		
		System.out.println("Welcome to Jordan's Bank");
        System.out.println("=========================");
        System.out.println("Press enter to create an account with us!");
        promptPause();
        
	}// end createAccount method
	
	
	
	public static void mainMenu() {
		CheckingAccount myAccount = new CheckingAccount();
		
		int choice;
		
		System.out.println("\nWelcome to Jordan's Bank");
        System.out.println("=========================");
        System.out.println("1. Check/Withdraw/Deposit balance");
        System.out.println("2. Apply for Early Payday");
        System.out.println("3. Balances Due");
        System.out.println("4. Interest Earned");
        System.out.println("0. Exit");
        
        // gathering user input and calling on the necessary methods and classes
        
        do {
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    myAccount.accountOptions();
                    break;
                case 2:
                    myAccount.setEarlyPayDay(false);
                    break;
                case 3:
                	myAccount.getBalanceDue();
                    break;
                case 4:
                    myAccount.applyInterest();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            } // end switch-case statement
            
        } while (choice != 0); // end do-while loop
        
	}// end mainMenu method
	
	public static void promptPause() {
		input.nextLine();
		System.out.println("----------------------------------");
	}
	
}// end Main class
