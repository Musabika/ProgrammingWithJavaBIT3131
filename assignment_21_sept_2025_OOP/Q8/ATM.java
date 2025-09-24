package assignment_21_sept_2025_OOP.Q8;

import assignment_21_sept_2025_OOP.Q1.BankAccount;

import java.util.Scanner;

public class ATM {
    public static final  BankAccount[]
            bankAccounts = {
            new BankAccount("Claude Iranzi", 1234),
            new BankAccount("Elisa Kwihangana", 5678),
            new BankAccount("Adolphe Nayituriki", 4321)
    };
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the ATM!");
        boolean check = true;
        System.out.print("Please enter your pin: ");
        int pin = sc.nextInt();
        BankAccount bankAccount = checkBankAccount(pin);
        if (bankAccount != null) {
            System.out.println("Welcome " + bankAccount.getCustomerName() + "!");
            do {
                System.out.println("What do you want to do?");
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to Deposit: ");
                        double amount = sc.nextDouble();
                        bankAccount.deposit(amount);
                        break;
                    case 2:
                        System.out.print("Enter amount to Withdraw: ");
                        double amount2 = sc.nextDouble();
                        bankAccount.withdraw(amount2);
                        break;
                    case 3:
                        check = false;
                        break;
                    default:
                        System.out.println("Invalid choice");

                }
            } while (check);
            System.out.println("Thank you for using our Bank Account");
        } else {
            System.out.println("Invalid pin!");
        }
        sc.close();

    }
    public static BankAccount checkBankAccount(int pin) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getPinCode() == pin) {
                return bankAccount;
            }
        }
        return null;
    }
}
