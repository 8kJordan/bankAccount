// Class written by Jordan Sanchez
// This will be the abstract class, that will set rules for a Checking account
// a Credit card account and maybe a savings account

package abstractClass;

public abstract class Account {
	// Fields
	private String accountHolderName;
	private String accountNumber;
	private String accountType;
	
	// Constructors
	
	public Account(String accountHolderName, String accountNumber, String accountType) {
		super();
		setAccountHolderName(accountHolderName);
		setAccountNumber(accountNumber);
		setAccountType(accountType);
	}// end full argument constructor
	
	
	public Account() {
		super();
	}// end no argument constructor
	
	// Abstract methods
	
	public abstract void isOverdrawn();
	public abstract void applyInterest();
	public abstract double getBalanceDue();

	// Concrete methods
	
	// Getters and Setters
	
	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	//toString

	@Override
	public String toString() {
		return "Account [accountHolderName=" + accountHolderName + ", accountNumber=" + accountNumber + ", accountType=" + accountType + "]";
	}
	
	
	
	
	
}// end Account class



