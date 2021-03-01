import java.util.Random;
import java.util.Scanner;
// bankingSoftware class
public class BankingSoftware {
    // main method
    public static void main(String[] args) {

// create instance of Scanner class
        Scanner input = new Scanner(System.in);

        // variable initializations for bankingSoftware class
        int choice;
        int clientsNo = 0;
        int accCounter = 0;
        // create new array of objects of Client class
        Client[] clients;
        clients = new Client[10];

        /*Random rand;
        rand = new Random();*/
        //int[] NumAccounts;

        // create new array to keep track of accounts
        int[] NumAccounts;
        NumAccounts = new int[100];
        // welcome message
        System.out.println("Welcome to Jack's Banking Software" + "\n");

// the bankingSoftware screen continues to loop if the user's choice is 1-4, if choice is 5 then the loop breaks.
        while (true) {
            // displays all the user's choices
            System.out.println("Create new client: Choose 1");
            System.out.println("Display Client Information: Choose 2");
            System.out.println("Deposit Cash: Choose 3");
            System.out.println("Withdraw Cash: Choose 4");
            System.out.println("Quit The Program: Choose 5");
            System.out.println();
            System.out.println("Please Enter Your Choice: ");
// stores user's choice input in choice variable
            choice = input.nextInt();

// if user's choice is to create new client then run the following code
            if (choice == 1) {
// display first instruction
                System.out.println("Enter the name of new client:");
                //user's input is stored in the name variable.
                String name = input.next(); // reads string
// program asks user for how many accounts the client wants to create.
                System.out.println("How many accounts does client want to create?");
                // user's input is stored in the size variable
                int size = input.nextInt();
// create new object of the client class.
                Client client = new Client(name, size);
                // sets the index of the array of clients to the current client
                clients[clientsNo] = client;
                // increases the number of clients variable so next time the program loops it will fill the next index of clients array.
                clientsNo++;
// this loops the following script until all the number of desired accounts have been created for the current client.
                while (client.currentAcc < size) {
// the following code was the non-bonus version of the account number creation.

                    /*System.out.println("Enter the five digit account number for the new account " + (client.currentAcc+1)+": ");
                    int accNumber = input.nextInt();*/
                    //NumAccounts = new int[size];

                    // bonus version of the account number creation which randomly assigns an account number for each new account.
                    System.out.println("The randomly generated account number for the new account "+ (client.currentAcc+1)+": ");
                    // stores newly created  random account number in the accNumber variable.
                    int accNumber = 10000 + new Random().nextInt(90000);
// this loop is in place to check that two accNumbers are not the same by checking if contains is true or false, if there is already an acc number the same it creates another one and restarts the process.
                    while(BankingSoftware.contains(NumAccounts, accNumber)){
                        accNumber = 10000 + new Random().nextInt(90000);
                    }
                    // once it is checked to not be the same as any existing accNumber, it adds it to the array of account numbers.
                    NumAccounts[accCounter] = accNumber;
                    // account counter is increased by one each time a new account number is created.
                    accCounter++;
                    // display clients newly generated account number.
                    System.out.println(accNumber);

                    // prompt the user to input the opening balance for the new account
                    System.out.println("Enter the opening balance for the new account:");
                    // store user's input in accBalance variable.
                    int accBalance = input.nextInt();
// prompt user for the type of new account being created.
                    System.out.println("Enter the type of new account:");
                    // store users input in accName variable.
                    String accName = input.next();



                    // declaring object of BankAccount class.

                    BankAccount acc = new BankAccount(accNumber, accBalance, accName);
                    // calls method of client
                    client.assign(acc);
                }
// if the user's choice is to display client's information then run the following script.
            }else if (choice == 2) {
// prompt user for which client they would like to display info for.
                System.out.println("Which client: ");
// loop the following script for the amount of clients currently saved in the system
                for(int i = 0; i < clientsNo; i++){
// displays all current clients which are saved in system memory
                    System.out.println(i+1 + ": " +clients[i].name + " ");
                }
// store user's input in clientIndex variable
                int clientIndex = input.nextInt();
                // display the index of the client the user wishes to access by calling the display method from client class.
                clients[clientIndex-1].display();
// if user's choice is to deposit cash then run the following script.
            } else if (choice == 3) {
                // prompt user to choose a client.
                System.out.println("Which client: ");
// loop the following script for the amount of clients currently saved in the system
                for(int i = 0; i < clientsNo; i++){
// displays all current clients which are saved in system memory
                    System.out.println(i+1 + ": " +clients[i].name + " ");

                }
                // stores user's input in clientIndex variable.
                int clientIndex = input.nextInt();
                // calls the deposit method from the client class.
                clients[clientIndex-1].deposit();
// if the user chooses to withdraw cash then run the following script.
            } else if (choice == 4) {
                // prompt user to choose a client.
                System.out.println("Which client: ");
// loop the following script for the amount of clients currently saved in the system
                for(int i = 0; i < clientsNo; i++){
// displays all current clients which are saved in system memory
                    System.out.println(i+1 + ": " +clients[i].name + " ");

                }
                // stores user's input in clientIndex variable.
                int clientIndex = input.nextInt();
                // calls the withdraw method from the client class.
                clients[clientIndex-1].withdraw();
// if the user chooses to quit the program then run the following script.
            } else if (choice == 5) {
                // goodbye message
                System.out.println("Goodbye, have a great day!");
                // break the loop, which ends the program.
                break;

            } else { // if the user input is anything but 1-5 then display that is not an option.
                System.out.println("That is not an option, please select one option 1-5");
            }


        }
    }
    // method to check if there is already an accNumber that is the same as the one being created.
    public static boolean contains(int[] nAcc, int accNumber){
        // loops through the array which stores all account number already assigned to an account.
        for(int i =0; i< 100; i++){
            if(nAcc[i] == accNumber){
                return true; // if there is an account number the same as the one being created returns contains as true
            }
        }return false;// if no accNumber matches the new one contains returns false.
    }

}