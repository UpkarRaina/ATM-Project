import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    /*
    The Account class encapsulates the details and operations related to a bank account. 
    It includes methods for managing checking and saving accounts.
     */
    
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$',###,##0.00");




    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }



    // Deducts the specified amount from the checking balance and returns the new balance.
    public double calcCheckingWithdraw(double amount) {
        checkingBalance -= amount;
        return checkingBalance;
    }
    // Deducts the specified amount from the saving balance and returns the new balance
    public double calcSavingWithdraw(double amount) {
        savingBalance -= amount;
        return savingBalance;
    }
    // Adds the specified amount to the checking balance and returns the new balance.
    public double calcCheckingDeposit(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }
    // Adds the specified amount to the saving balance and returns the new balance.
    public double calcSavingDeposit(double amount) {
        savingBalance += amount;
        return savingBalance;
    }




    // Prompts the user to withdraw a specified amount from the checking account. 
    // It checks if the balance is sufficient before performing the withdrawal.

    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient funds. Balance cannot be negative.\n");
        }
    }

    // Prompts the user to withdraw a specified amount from the saving account.
    // It checks if the balance is sufficient before performing the withdrawal.

    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Insufficient funds. Balance cannot be negative.\n");
        }
    }

    // Prompts the user to deposit a specified amount into the checking account and updates the balance.

    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to deposit to Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Invalid amount.\n");
        }
    }

    // Prompts the user to deposit a specified amount into the saving account and updates the balance.    

    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to deposit to Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Invalid amount.\n");
        }
    }
}