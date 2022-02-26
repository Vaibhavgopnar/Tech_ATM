package Tech_ATM;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

	private int customerNumber;
	private int pinNumber;
	private double checkingBalance=0;
	private double savingBalance =0 ;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	public int getCustomerNumber() {
		return customerNumber;
	}
	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public double getSavingBalance() {
		return savingBalance;
	}
	
	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}
	
	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}
	
	public double calcCheckingDeposit(double amount ) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}
	
	public double calcSavingDeposite(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}
	
	public void getCheckingWithdrawInput() {
		System.out.println("Checking Account Balance: "+moneyFormat.format(checkingBalance));
		System.out.println("Enter Amount for Withdraw");
		double amount =input.nextDouble();
		
		if((checkingBalance = amount) >= 0) {
			calcCheckingWithdraw(amount);
			System.out.println("New Account Balance : "+moneyFormat.format(checkingBalance));
		}
		else {
			System.out.println("Balance Cannot be Negative  \n");
		}
	}
	
	public void getSavingWithdrawInput() {
		System.out.println("Saving Balance : "+moneyFormat.format(savingBalance));
		System.out.println("Amount you want to withdraw from saving Account : ");
		double amount = input.nextDouble();
		
		if((savingBalance - amount) >= 0) {
			calcSavingWithdraw(amount);
			System.out.println("New Saving Account Balance : "+moneyFormat.format(savingBalance));
		}
		else {
			System.out.println("Balance cannot be Negative . \n");
		}
	}
	
	public void getCheckingDepositInput() {
		System.out.println("Checking Account Balance : "+moneyFormat.format(checkingBalance));
		System.out.println("Amount for Deposit");
		double amount = input.nextDouble();
		
		if((checkingBalance + amount) >= 0) {
			calcCheckingDeposit(amount);
			System.out.println("New Account Balance : "+moneyFormat.format(checkingBalance));
		}
		else {
			System.out.println("Balance Cannot be Negative .  \n");
		}
	}
	
	public void getSavingDepositInput() {
		System.out.println("Saving Account Balance :"+moneyFormat.format(savingBalance));
		System.out.println("Amount you want to Saving Account: ");
		double amount = input.nextDouble();
		
		if ((savingBalance + amount)>=0) {
			calcSavingDeposite(amount);
			System.out.println("New Saving Account Balance: "+moneyFormat.format(savingBalance));
		}
		else {
			System.out.println("Balance Cannot be Negative . \n");
		}
	}
	
	
}
