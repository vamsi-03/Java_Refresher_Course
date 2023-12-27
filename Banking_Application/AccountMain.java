package Assignment.Assignment2;

import java.util.*;

public class AccountMain{
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Welcome to Banking Application");
    while (true) {
        System.out.println("\nSelect Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Exit");

        int choice = sc.nextInt();

        if (choice == 3) {
            System.out.println("Thank you for using our application!");
            break;
        }

        System.out.println("Enter Initial Balance:");
        double balance = sc.nextDouble();

        Account account = null;

        switch (choice) {
            case 1:
                account = new SavingsAccount(balance);
                break;
            case 2:
                account = new CurrentAccount(balance);
                break;
            default:
                System.out.println("Invalid Choice!");
                continue;
        }

        while (true) {
            System.out.println("\nSelect Operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");

            int operation = sc.nextInt();

            if (operation == 3) {
                System.out.println("Thank you for using our application!");
                break;
            }

            System.out.println("Enter Amount:");
            double amount = sc.nextDouble();

            switch (operation) {
                case 1:
                    
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).calculateInterest();
                    }
                    account.deposit(amount);
                    System.out.println("Updated Balance: Rs." + account.getBalance());
                    break;
                case 2:
                    if (account instanceof CurrentAccount && amount > 50000) {
                        ((CurrentAccount) account).deductFee(amount);
                    }
                    account.withdraw(amount);
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).calculateInterest();
                    }
                    System.out.println("Updated Balance: Rs." + account.getBalance());
                    break;
                default:
                    System.out.println("Invalid Operation!");
                    continue;
            }
        }
    }

    sc.close();
    }
}