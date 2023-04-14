package abstractClass;
import java.util.*;
public class CheckingAccount extends Account {
	
	// Fields
	
	private boolean earlyPayDay;
	private double maxAccountWithdrawal;
	private double balance;
	
	
	// Constructors
	public CheckingAccount(String accountNumber, String accountType, boolean earlyPayDay,
			double maxAccountWithdrawal, String accountHolderName, double balance) {
		
		super(accountHolderName, accountNumber, accountType);
		setEarlyPayDay(earlyPayDay);
		setMaxAccountWithdrawal(maxAccountWithdrawal);
		setInitialBalance(balance);
	}// end full argument constructor
	
	
	public CheckingAccount() {
		super();
		makeCheckingAccount();
	}// end no argument constructor


	// Setters and Getters
	public boolean isEarlyPayDay() {
		return earlyPayDay;
	}


	public void setEarlyPayDay(boolean earlyPayDay) {
		int timeInMonths = accountAge();
		
		// setting requirement for early pay day
		if(timeInMonths > 6) {
			this.earlyPayDay = true;
			System.out.println("You meet the requirements! You are now able to receive payment up to two days early! ");
		}// end if statement
			
		else {
			this.earlyPayDay = false;
			System.out.println("You do not meet the minimum requirements for early pay day");
		}// end else statement
			
		
		this.earlyPayDay = earlyPayDay;
	}


	public double getMaxAccountWithdrawal() {
		return maxAccountWithdrawal;
	}


	public void setMaxAccountWithdrawal(double maxAccountWithdrawal) {
		this.maxAccountWithdrawal = maxAccountWithdrawal;
	}


	public double getBalance() {
		return balance;
	}


	public void setInitialBalance(double balance) {
		
		if(balance < 0)
			System.out.println("You cannot deposit a negative amount! Please input a positive integer ");
		else if(balance > 150000)
			System.out.println("Initial deposit too high! Initial deposits above $150000 are only available to premium clientel, please deposit "
					+ "less than $150000");
		else
			this.balance = balance;
	}

	// Concrete Methods
	
	@Override
	public void isOverdrawn() {
		System.out.print("\nWe cannot do the operation you intended as ");
		System.out.println("your account seems to be overdrawn, you currently owe $" + Math.abs(balance));
	
	}// end isOverdrawn method


	@Override
	public void applyInterest() {
		double interestRate = 0.05; // annual interest rate of 5%
		
		if(balance <= 0)
			System.out.println("You have not earned any interest as you have a balance of 0 or below");
		else {
			int timeInMonths = accountAge();
			
			if(timeInMonths > 0) 
				System.out.println("You have earned a total of $" + balance * (interestRate/12) * timeInMonths + " in interest! ");
			else
				System.out.println("You have not had the account with us for long enough to earn interest! ");
			
		}// end else statement
			
	}// end applyInterest method


	@Override
	public double getBalanceDue() {
		
		if(balance < 0 ) {
			// getting the absolute value of negative balance
			double absoluteValueNum = Math.abs(balance);
			System.out.println("Your balance due is $" + absoluteValueNum );
			return absoluteValueNum;
		}else {
			System.out.println("\nYou do not owe anything! ");
			return 0;
		}// end conditional statements
		
	}// end getBalanceDue method

	// method that prompts the user for the information needed to make a bank account
	public void makeCheckingAccount() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Thank you for choosing Jordan's Bank to handle your checkings account!");
		System.out.print("Please enter the following information, \nYour name: ");
		String name = input.nextLine();

		System.out.print("Initial balance to be deposited: ");
		
		while(true) {
			
			try {
				double tempBalance = input.nextDouble();
				
				setInitialBalance(tempBalance);
			// checking if the setter method went through
			if(tempBalance != balance)
				continue;
			else
				break;
				
			}catch(InputMismatchException e) {
				input.next(); // clearing input cache
				System.out.println("\nPlease input a valid amount in $ ");
				
			}// end try-catch
			
		}// end while
				
		
	}// end makeCheckingAccount method
	
	// getting the age of the account in months
	public int  accountAge() {
		Scanner ageInput = new Scanner(System.in);
		int accountAgeInMonths;
		System.out.print("How long have you had an account with us? Please input a date length in months: ");
		
		
		while(true) {
			try {
				accountAgeInMonths = ageInput.nextInt();
				
				if(accountAgeInMonths <= 0) 
					return 0;
				else 
					return accountAgeInMonths;
				
			}catch(InputMismatchException e) {
				ageInput.next(); // clearing buffer
				System.out.println("Please input an integer representing the amount of months you have had the account for ");
				
			}// end try catch statement
			
		}// end while loop
		
	}// end accountAge
	
	// this method will allow the user to view, deposit and retire funds from their balance
	public void accountOptions() {
		Scanner input = new Scanner(System.in);
		int choice;
		
		System.out.println("\nPlease choose from one of the following options");
		System.out.println("=============================================");
		System.out.println("1. Check current balance");
	    System.out.println("2. Deposit");
	    System.out.println("3. Withdraw");
	    System.out.println("0. Exit to main menu");
	    
	    do {
	    	System.out.print("Enter your choice: ");
	    	choice = input.nextInt();
	    	
	    	
	    	switch(choice) {
	    		case 1:
	    			System.out.println("Your current balance is $" + getBalance());
	    			break;
	    		case 2:
	    			double depositAmount = deposit();
	    			balance = balance + depositAmount;
	    			System.out.println("You deposited $" + depositAmount + " for a total of $" + balance + " inside of your account ");
	    			break;
	    		case 3:
	    			withdraw();
	    			break;
	    		case 0:
	    			System.out.println("Exiting to main menu.....\n");
	    			break;
	    		default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
	    		
	    	}// end switch-case
	    	
	    }while(choice != 0);
	    
	   
	    
	}// end accountOptions method
	
	public double deposit() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("How much would you like to deposit? ");
		// prompting the user for the deposit amount
		while (true) {
			
			try {
				double depositAmount = input.nextDouble();
				
				if(depositAmount > 0) 
					return depositAmount;
				
				else {
					System.out.print("\nYou cannot deposit anything that is $0 or less than $0, please enter a valid number: ");
					continue;
				}// end else statement
					
				
			}catch(InputMismatchException e) {
				input.next();
				System.out.print("Please input a valid amount: ");
			}// end try-catch statements
			
		}// end while loop
		
	}// end deposit method
	
	public double withdraw() {
		Scanner input = new Scanner(System.in);
		double withdrawAmount;
		System.out.print("How much would you like to withdraw? ");
		
		
		while(true) {
			
			try {
				withdrawAmount = input.nextDouble();
				
				if(balance < 0) {
					isOverdrawn();
					return 0;
				}// end if
					
				else if(withdrawAmount <= 0) {
					System.out.print("\n You cannot withdraw anything that is $0 or less than $0, please enter a valid number: ");
					continue;
				}// end if
				else if(balance - withdrawAmount < 0) {
					System.out.println("You have withdrawn more than your current balance of $" + balance);
					balance =  balance - withdrawAmount;
					return balance;
					
				}// end else if
				else {
					balance = balance-withdrawAmount;
					System.out.print("You have withdrawn $" + withdrawAmount );
					System.out.println(", your new balance is $" + balance);
					return balance;
				}// end else
					
				
			}catch(InputMismatchException e) {
				input.next(); // clearing cache
				System.out.print("Please input a valid amount: ");
				
			}// end try-catch statements
			
		}// end while loop
			

	}// end withdraw method
	
	@Override
	public String toString() {
		return "CheckingAccount [earlyPayDay=" + earlyPayDay + ", maxAccountWithdrawal=" + maxAccountWithdrawal
				+ ", balance=" + balance + "]" + super.toString();
	}

	
}// end CheckingAccount class


// still have that same shit problem, ima gym, come back w some fresh brain then do the good goo ga

