package Project1;

import java.util.Scanner;
/*
 * Appas Bank
 * Bank Account Parameters:
 * public Name -> String ✓
 * private Balance -> double ✓ 
 * private Date of Birth -> String ✓
 * private SSN -> int (Maybe String) ✓
 * private Account Number -> int ✓
 * 
 * Bank Account Methods:
 * Constructor 
 * Getters and Setters
 * Deposit
 * Withdraw
 * Transfer (HomeWork)
 * Balance
 * Menu
 * Compound Interest
 * Simple Interest (HomeWork)
 * Authentication Basic
 * Authentication Advanced (HomeWork?)
 * 
 * Bank Account Constructor
 * Name, Balance, SSN, Account Number, Date of Birth
 * Name, SSN
 */

public class BankAccount {

    // Bank Account Parameters
    public String name;
    private double balance;
    private String dob;
    private int ssn;
    private int accountNumber;
    public double interestRate = 0.01;
    public int period = 4; // quarterly

    // Bank Account Constructor
    public BankAccount(String name, int ssn, double balance, int accountNumber, String dob) {
        this.name = name;
        this.ssn = ssn;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.dob = dob;
        if (balance >= 10000) {
            System.out.println("Congratulations! You qualify for a savings account.");
            System.out.println("Would you like to open a savings account? (Y/N)");
            try (Scanner sc = new Scanner(System.in)) {
                String response = sc.nextLine();
                if (response.equals("Y") || response.equals("y")) {
                    System.out.println("Please enter the initial balance for your savings account:");
                    double savingsBalance = sc.nextDouble();
                    System.out.println("Please choose an interest type for your savings account:");
                    System.out.println("1. Simple interest");
                    System.out.println("2. Compounded interest");
                    int interestType = sc.nextInt();
                    if (interestType == 1) {
                        System.out.println("Please enter the annual interest rate for your savings account (APY):");
                        double savingsInterest = 0.0;
                        System.out.println("Your savings account has earned $" + savingsInterest + " in interest.");
                        balance += savingsBalance + savingsInterest;
                    } else if (interestType == 2) {
                        System.out.println("Please enter the annual interest rate for your savings account (APY):");
                        double apy = 0.0001;
                        System.out.println("Please enter the number of years you will keep your money in your savings account:");
                        int years = sc.nextInt();
                        double savingsInterest = compoundInterest(savingsBalance, apy, years, 4);
                        System.out.println("Your savings account has earned $" + savingsInterest + " in interest.");
                        balance += savingsBalance + savingsInterest;
                    } else {
                        System.out.println("Invalid input. Savings account not created.");
                    }
                } else {
                    System.out.println("No savings account created.");
                }
            }
        }
    }

    // Bank Account Constructor
    public BankAccount(String name, int ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    

    // Bank Account Methods

    // Note you do need to create a getter for public variables however it is best
    // practice to create a getter for all variables

    /*
     * Getters and Setters
     */

    public String getName() {
        return this.name;
    }

    public double getbalance() {
        return this.balance;
    }

    public String getdob() {
        return this.dob;
    }

    public int getssn() {
        return this.ssn;
    }

    public int getaccountNumber() {
        return this.accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Should only be used by during the creation of the account never after instead
     * see deposit and withdraw
     */
    public void setbalance(double balance) {
        this.balance = balance;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }

    public void setssn(int ssn) {
        this.ssn = ssn;
    }

    public void setaccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    // Create a mthod that will subtract a mothly fee from the balance
    // this method will take a double as a parameter
    // this method will subtract the fee from the balance
    // Netflix subscription is $12.99
    public void monthlyFee(double fee) {
        withdraw(fee);
    }

    // Create a method that will print a menu to the user
    // This is called a helper method / function
    public static int menu() {
        int choice;
        try (Scanner input = new java.util.Scanner(System.in)) {
            System.out.println("Welcome to Appas Bank");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer"); // HomeWork
            System.out.println("4. Balance");
            System.out.println("5. Compound Interest");
            System.out.println("6. Simple Interest"); // HomeWork
            System.out.println("0. Exit");
            System.out.println("Please enter your choice: ");
            choice = input.nextInt();
        }
        return choice;
    }

    public void printBalance() {
        System.out.println("Your balance is: $" + this.balance);
    }

    // Create a method that will interact with the user based on their choice from
    // the menu method
    // This method will take a Bank Account as a parameter
    public static void interact(BankAccount account) {
        // get the choice from the menu method
        int choice = menu();
        try (// create a scanner object
        Scanner input = new java.util.Scanner(System.in)) {
            if (choice == 1) {
                System.out.println("Please enter the amount you would like to deposit: ");
                double amount = input.nextDouble();
                account.deposit(amount);
                account.printBalance();
            } else if (choice == 2) {
                System.out.println("How much would you like to withdraw?");
                double amount = input.nextDouble();
                account.withdraw(amount);
                account.printBalance();
            } // place holder for choice 3
            else if (choice == 4) {
                account.printBalance();
            } else if (choice == 5) {
                System.out.println("How many years? (Whole numbers only)");
                int years = input.nextInt();
                BankAccount.compoundInterest(account.getbalance(), years, account.interestRate, account.period);
                account.printBalance();
            } // place holder for choice 6
            else if (choice == 0) {
                System.out.println("Thank you for banking with Appas Bank");
            } else { // this would catch any invalid choices like
                System.out.println("Invalid choice");
            }
        }

    }

    // Create a method that will calculate the interest on the balance using
    // compound interest
    // P(1 + R/n)^(nt) - P
    // A = P(1 + R/n)^(nt)
    // P = Principal
    // R = Rate
    // n = number of times interest is compounded per year (annum)
    // t = number of years
    // This method will take a double as an argument
    // This method will return a double

    // P can be this.balance or getBalance() if you would like to use a getter

    public static double compoundInterest(double principal, double apy, double rate, int annum) {
        double amount = principal * Math.pow(1 + (rate / annum), annum * apy);
        double roundedAmount = Math.round(amount * 100.0) / 100.0;
        double compinterest = amount - principal; // A-P
        compinterest = Math.round(compinterest * 100.0) / 100;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Current Period is: " + annum + " times per year");
        System.out.println("Selected Time is: " + apy + " years");
        System.out.println("Compound Interest after " + apy + " years is: $" + compinterest);
        System.out.println("Total Amount after " + apy + " years is: $" + roundedAmount);
        return compinterest;
    }
    public static void overDraft(BankAccount bank, double value) {
        double balance = bank.getbalance();
        if (value > balance) {
            double overdraft = value - balance;
            System.out.println("You are about to overdraft your account by $" + overdraft);
            System.out.println("Do you want to proceed? (y/n)");
            try (Scanner input = new Scanner(System.in)) {
                String answer = input.nextLine();
                if (answer.equals("y")) {
                    bank.withdraw(value);
                    bank.withdraw(35);
                    System.out.println("Overdraft fee of $35 applied.");
                } else {
                    System.out.println("Withdrawal canceled.");
                }
            }
        } else {
            bank.withdraw(value);
        }
    }
  
    public static void transferMoney(BankAccount from, BankAccount to, double amount) {
        boolean canTransfer = true;
        if (from.getbalance() < amount) {
            System.out.println("Insufficient funds.");
            canTransfer = false;
        }
        if (canTransfer) {
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("$" + amount + " transferred from " + from.name + "'s account to " + to.name + "'s account.");
        }
    }
    public static double simpleInterest(double principal, double rate, double time) {
        double interest = (principal * rate * time) / 100.0;
        return interest;
    }
    
    

}
    
