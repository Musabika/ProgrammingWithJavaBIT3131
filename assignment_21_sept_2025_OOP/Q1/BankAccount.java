package assignment_21_sept_2025_OOP.Q1;

public class BankAccount {
    private  double balance;
    private  final long accountNumber;
    private final String customerName;
    private  final int pinCode;
    public BankAccount(String customerName, int pinCode) {
        this.customerName = customerName;
        this.accountNumber = (long) (Math.random() * 10_000_000_000L );
        this.pinCode = pinCode;
    }
    public void deposit(double balance) {
        this.balance += balance;
        displayMessage("You have successfully deposited "+ balance);
    }

    public void withdraw(double balance) {
        if(this.balance < balance) {
            System.out.println("Insufficient funds to withdraw");
            return;
        }
        this.balance -= balance;
        displayMessage("You have successfully Withdraw "+ balance);
    }
    private void displayMessage(String message) {
        System.out.println("Dear Customer "+ customerName);
        System.out.println(message);
        System.out.println("Your New balance is "+ this.balance);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public int getPinCode() {
        return pinCode;
    }
    public String getCustomerName() {
        return customerName;
    }
}
