import java.util.Scanner;

class BankAccount {
    private double accountBalance;

    public BankAccount(double initialBalance) {
        this.accountBalance = initialBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            return true;
        }
        return false; 
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            displayOptions();
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    performDeposit(scanner);
                    break;
                case 3:
                    performWithdrawal(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        } while (option != 4);

        scanner.close();
    }

    public void checkBalance() {
        System.out.println("Your account balance: ₹" + userAccount.getAccountBalance());
    }

    public void performDeposit(Scanner scanner) {
        System.out.print("Enter amount to deposit (in ₹): ");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
        System.out.println("Deposited ₹" + amount + " successfully.");
    }

    public void performWithdrawal(Scanner scanner) {
        System.out.print("Enter amount to withdraw (in ₹): ");
        double amount = scanner.nextDouble();
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawn ₹" + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
}

public class ATMSimulator {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(15000);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
