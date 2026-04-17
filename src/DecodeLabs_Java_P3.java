import java.util.Scanner;

// This class handles all account-related operations (Vault)
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else {
            balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}

// This class handles user interaction (Lobby)
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;

        do {
            showMenu();

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                scanner.next(); // clear wrong input
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleDeposit();
                    break;
                case 2:
                    handleWithdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    private void showMenu() {
        System.out.println("\n==== ATM MENU ====");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose option: ");
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit failed. Enter positive amount.");
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed. Check balance or amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }
}

// Main class
public class DecodeLabs_Java_P3{
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // initial balance
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}