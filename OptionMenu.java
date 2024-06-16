import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$',###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();


    // Prompts the user to enter their customer number and PIN.
    // It validates the input against the stored data and allows access if the credentials are correct.
    // It limits the number of attempts to 3.
    public void getLogin() throws IOException {
        int attempts = 3; // Max attempts allowed
        boolean authenticated = false;

        data.put(101010, 3333);
        data.put(202020, 4444);

        System.out.println("Welcome to the ATM Project!");

        // The loop continues as long as the number of attempts is greater than 0 and the user is not authenticated.
        while (attempts > 0 && !authenticated) {
            try {
                // The program prompts the user to enter their customer number.
                System.out.print("Enter your customer number: ");
                setCustomerNumber(menuInput.nextInt());
                
                // The program then prompts the user to enter their PIN.
                System.out.print("Enter your PIN: ");
                setPinNumber(menuInput.nextInt());

                // int cn: Stores the customer number retrieved using the getCustomerNumber method.
                // int pn: Stores the PIN retrieved using the getPinNumber method.
                int cn = getCustomerNumber();
                int pn = getPinNumber();


                // data.containsKey(cn): Checks if the data map contains the entered customer number as a key.
                // data.get(cn) == pn: Checks if the PIN associated with the customer number in the data map matches the entered PIN.
                if (data.containsKey(cn) && data.get(cn) == pn) {
                    authenticated = true;
                    // f both conditions are met (customer number exists and the PIN matches), the authenticated flag is set to true.
                    getAccountType();
                } else {
                    attempts--;
                    System.out.println("\nWrong Customer Number or Pin Number. Attempts left: " + attempts + "\n");
                    // If the entered customer number and PIN do not match any entry in the data map, the attempts counter is decremented by 1.
                }

            // try-catch Block: Surrounds the input reading and validation code to handle exceptions (e.g., entering non-numeric characters).
            // If an exception occurs (e.g., the user enters non-numeric input), an error message is displayed.
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Only numbers are allowed.\n");
                menuInput.next(); // clear invalid input
                attempts--;
            }
        }

        // After the loop, if the user is still not authenticated (i.e., they failed to enter correct credentials within the allowed attempts),
        //  a message is displayed indicating too many failed attempts, and the program exits.
        if (!authenticated) {
            System.out.println("Too many failed attempts. Exiting.");
        }
    }

    // Displays the checking account options to the user: view balance, withdraw funds, deposit funds, or exit. 
    // It processes the user’s choice and calls the corresponding method.

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
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
                System.out.println("Thank you for using this ATM. Bye.");
                break;
            default:
                System.out.println("\nInvalid choice.\n");
                getChecking();
                break;
        }
    }

    // Displays the saving account options to the user: view balance, withdraw funds, deposit funds, or exit. 
    // It processes the user’s choice and calls the corresponding method.

    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
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
                System.out.println("Thank you for using this ATM. Bye.");
                break;
            default:
                System.out.println("\nInvalid choice.\n");
                getSaving();
                break;
        }
    }

    // Prompts the user to select an account type: checking, saving, or exit.
    // It processes the user’s choice and calls the corresponding method.

    public void getAccountType() {
        System.out.println("Select the account you want to access: ");
        System.out.println(" Type 1 - Checking Account");
        System.out.println(" Type 2 - Saving Account");
        System.out.println(" Type 3 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using this ATM. Bye.\n");
                break;
            default:
                System.out.println("\nInvalid choice.\n");
                getAccountType();
                break;
        }
    }
}