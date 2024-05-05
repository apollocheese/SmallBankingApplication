import java.util.Scanner;

public class BankingApplication{
	
	public static void main(String[] args) {
		BankAccount firstCust = new BankAccount("Tiger Woods", "B34927502");
		firstCust.showMenu();
	}
}

class BankAccount {
	int bal;
	int prevTransaction;
	String custName;
	String custID;
	
	BankAccount(String cname, String cid)
	{
		custName = cname;
		custID = cid;
				
	}
	
	
	
	void deposit(int amount){
		
		if (amount != 0)
			bal = bal + amount;
			prevTransaction = amount;
	}
	
	void withdraw(int amount) {
		if (amount != 0)
			bal = bal - amount;
			prevTransaction = -amount;
	}
	
	void getPrevTransaction() {
		if (prevTransaction > 0) {
			System.out.println("Deposit: $" + prevTransaction);
		}
		else if (prevTransaction < 0) {
			System.out.println("Withdrawl: $" + Math.abs(prevTransaction));
		}
		else
		{
			System.out.println("No transaction occured");
		}
	}
	
	void showMenu()
	{
		char option ='\0';
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Welcome "+custName);
		System.out.println("Your ID is "+custID);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("======================================================================");
			System.out.println("Enter an option: ");
			System.out.println("======================================================================");
			option = scnr.next().charAt(0);
			System.out.println("\n");
			
			switch(option){
				
				case 'A':
					System.out.println("======================================================================");
					System.out.println("You chose 'Check Balance'! ");
					System.out.println("Balance: $" + bal);
					System.out.println("======================================================================");
					
					break;
				case 'B':
					System.out.println("======================================================================");
					System.out.println("You chose 'Deposit'! How much do you want to deposit ");
					System.out.println("======================================================================");
					
					int amount = scnr.nextInt();
					deposit(amount);
					
					System.out.println("You deposited $" + amount + " into your balance!");
					System.out.println("\n");
					
					break;
				case 'C':
					System.out.println("======================================================================");
					System.out.println("You chose 'Withdraw'!  How much do you want to withdraw?");
					System.out.println("======================================================================");
					
					int amount2 = scnr.nextInt();
					if (amount2 > bal) {
						System.out.println("I'm sorry! You do not have enough money to withdraw that much from your balance!");
					}
					else {
						withdraw(amount2);
						
						System.out.println("You withdrew $" + amount2 + " from your balance!");
						System.out.println("\n");
					}
					break;
				case 'D':
					System.out.println("======================================================================");
					System.out.println("You chose 'Previous transaction'! ");
					getPrevTransaction();
					System.out.println("======================================================================");
					
					break;
				case 'E':
					System.out.println("======================================================================");
					System.out.println("You chose 'Exit'! ");
					System.out.println("Thank you for using our services!");
					
					break;
				default:
					System.out.println("Invalid option. Choose Between A to E.");
					
					break;
					
			}
		}
		while(option != 'E');
				
					
	}
	
}