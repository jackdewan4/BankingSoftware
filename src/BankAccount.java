import java.util.Scanner;
// BankAccount class
public class BankAccount {
    // variable initializations
    public double accBalance;
    private int accNumber;
    public String accName;
    // create object of scanner class
    private Scanner input = new Scanner(System.in);
    // BankAccount constructor
    public BankAccount(int iaccNumber, double iaccBalance, String iaccName) {
        // set accNumber, accBalance, and accName to user's input and random accNumber generated in main method
        accNumber = iaccNumber;
        accBalance = iaccBalance;
        accName = iaccName;

    }
    // toString method to format the accounts array for the display method in client class
    public String toString() {
        return accName + " " + "Account no: " + accNumber + " has balance: " + "$" + accBalance + "\n";
    }

    // deposit method
    public double deposit(double amount) {
// if user deposits cash, add that amount into the accBalance of desired account
        if (amount >= 0) {
            accBalance += amount;
        }
        // returns the accBalance variable
        return accBalance;
    }

    // withdraw method
    public boolean withdraw(double amount) {
        // if the user withdraws less than the accBalance, subtract that amount from the balance of the specified.
        if(amount <= accBalance){
            accBalance -= amount;
            // if the amount was less than the accBalance, return withdraw true.
            return true;
        }
        // if the amount was greater than the accBalance, return withdraw false.
        return false;

    }
}
