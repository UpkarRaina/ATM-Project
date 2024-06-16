import java.io.IOException;
public class ATM {
    public static void main(String[] args) {
        OptionMenu optionMenu = new OptionMenu();

        // The try block contains the code that attempts to execute the login process by calling optionMenu.getLogin().
        try {
            optionMenu.getLogin();

        // The catch block is used to handle the exception if it occurs. It catches exceptions of type IOException.
        // IOException is a type of exception that occurs when there is an input-output operation failure
        // (like a failed file operation or network communication error).
        } catch (IOException e) {
            System.out.println("An error occurred during login.");

            // prints the stack trace of the exception to the console.
            // The stack trace provides detailed information about the exception,
            // including the sequence of method calls that led to the exception.
            // This is useful for debugging purposes.
            e.printStackTrace();
        }
    }
}