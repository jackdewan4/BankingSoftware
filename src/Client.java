
import java.util.Scanner;
// Client class
public class Client {
    // create object of Scanner class.
    private Scanner input = new Scanner(System.in);
    // variable initializations
    public String name;
    private BankAccount[] accounts;
    private int size;

    public int currentAcc;
    public double accTotal;
    // Client constructor
    public Client(String iname, int isize) {
        // set the size of the accounts array from user input, name of the client, and initialize the currentAcc counter variable.
        currentAcc = 0;
        size = isize;
        name = iname;
        accounts = new BankAccount[size]; // initialize size of array

    }
    // assign method
    public void assign(BankAccount acc){

// assigns the account to the client
        accounts[currentAcc] = acc;
        // increases the currentAcc counter variable
        currentAcc ++;

    }
    // display method
    public void display(){
        // initializes the accTotal back to zero every time the display method is called.
        accTotal = 0;
// loop for the length of the accounts array to display each account a client has.
        for(int i =0; i < accounts.length; i++  ){
            // display accounts in order from 1, ..., n.
            System.out.println("Account " + (i+1) + ":");
            // print out all account information for each account stored in array
            System.out.print(accounts[i]);
            // add to the accTotal variable, each accBalance.
            accTotal += accounts[i].accBalance;
        }
        // display the total balance after ading each accBalance in the for loop.
        System.out.println( "Total Balance: "+ "$" +accTotal);
        // print an extra line for proper spacing
        System.out.println();

    }
    // deposit method
    public void deposit(){
        // prompt user to choose the account they want to deposit to.
        System.out.println("Which account: ");
        // loop through all accounts the specified client has.
        for(int i =0; i < accounts.length; i++){
            // display each account the client has
            System.out.println("Account " + (i+1) + ":");
            // display each account name so the user knows which one to choose.
            System.out.println(accounts[i].accName);
        }
        // store user's input in accIndex variable
        int accIndex = input.nextInt();
        // display the account the user selected
        System.out.println("Selected account: " + accounts[accIndex-1].accName);
        // prompt the user to enter the amount they wish to deposit.
        System.out.println("Enter the amount of cash to deposit: ");
        // store the deposit amount in the amount variable.
        double amount = input.nextDouble();
        // call the deposit method from the BankAccount class.
        accounts[accIndex-1].deposit(amount);
    }

    // withdraw method
    public void withdraw(){
        // prompt user to choose the account they wish to withdraw from
        System.out.println("Which account: ");
        // loop through all accounts the specified client has.
        for(int i =0; i < accounts.length; i++){
            // display each account the client has
            System.out.println("Account " + (i+1) + ":");
            // display the account name so the user knows which one to choose.
            System.out.println(accounts[i].accName);
        }
        // store the user's input in the accIndex variable
        int accIndex = input.nextInt();
        // display the account the user selected
        System.out.println("Selected account: " + accounts[accIndex-1].accName);
        // prompt the user to enter the amount they wish to withdraw.
        System.out.println("Enter the amount of cash to withdraw: ");
        // store the user's input withdraw amount in the amount variable
        double amount = input.nextDouble();
        // call the withdraw method from BankAccount class.
        accounts[accIndex-1].withdraw(amount);
    }
}

