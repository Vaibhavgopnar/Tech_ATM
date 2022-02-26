package Tech_ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class LoginMenu extends Account{
	Scanner menuInput =new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$' ###,##0.00");
	
	HashMap<Long, Integer> data = new HashMap<Long, Integer>();
	
	public void getLogin() throws IOException{
		long x=1;
		do {
			try {
				data.put((long) 624727107,  743600);
				data.put((long)779848, 968912);
				
				System.out.println("	....Welcome to ATM Project.... \n");
				System.out.println("Enter Account Number");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter Your PIN Number");
				setPinNumber(menuInput.nextInt());
			}catch (Exception e) {
				System.out.println("\n"+"Invalid Characters. Only Number"+"\n");
				x=2;
			}
			
			int cn=getCustomerNumber();
			int pn=getPinNumber();
			if(data.containsKey(cn) && data.get(cn)==pn) {
				getAccountType();
			}else
				System.out.println("\n"+"Wrong Customer Number or PIN Number"+"\n");
		}while(x==1);
	}

	public void getAccountType() {
		System.out.println("Select Account You Want to Access : ");
		System.out.println("1.  	Current Account");
		System.out.println("2.     Saving Account ");
		System.out.println("3.      Exit");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			getChecking();
			break;
			
		case 2:
			getSaving();
			break;
			
		case 3:
			System.out.println("Thank you for visiting ATM  \n");
			break;
			
		default :
			System.out.println("\n  Invalid Choice  \n");
		}
	}
	
	public void getChecking() {
		System.out.println("Checking Account : ");
		System.out.println("1      Check Balance");
		System.out.println("2.      Withdraw Amount");
		System.out.println("3.      Deposit Amount");
		System.out.println("4.      Exit");
		
		int selection=menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Current Account Balance :"+ moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
			
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank you for Visiting ATM ");
			break;
			
		default:
			System.out.println("\n  Invalid Choice.  \n");

		}
	}
	
	public void getSaving() {
		System.out.println("Saving Account");
		System.out.println("1.      Check Balance");
		System.out.println("2.      Withdraw Amount");
		System.out.println("3.      Deposite Amount");
		System.out.println("4.      Exit");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Saving Account Balance : "+moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
			
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("\n Thank you for visiting ATM ");
			break;
			
		default:
			System.out.println("\n  Invalid Choice");
			getChecking();
		}
	}

}
