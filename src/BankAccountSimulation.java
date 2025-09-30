import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: ₹" + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
            System.out.println("✅ Successfully deposited ₹" + amount);
        } else {
            System.out.println("⚠️ Deposit amount must be greater than 0");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                transactionHistory.add("Withdrew: ₹" + amount + " | New Balance: ₹" + balance);
                System.out.println("✅ Successfully withdrew ₹" + amount);
            } else {
                System.out.println("⚠️ Insufficient balance!");
            }
        } else {
            System.out.println("⚠️ Withdrawal amount must be greater than 0");
        }
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("\n📜 Transaction History for " + accountHolderName + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🏦 Welcome to Bank Account Simulator");
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Deposit: ₹");
        double initialDeposit = sc.nextDouble();

        Account account = new Account(name, initialDeposit);

        while (true) {
            System.out.println("\n============================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.println("============================");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("👋 Thank you for using the Bank Account Simulator!");
                    sc.close();
                    return;
                default:
                    System.out.println("⚠️ Invalid choice! Please try again.");
            }
        }
    }
}
