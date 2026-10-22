package ATMProject;
import java.util.Scanner;

public class ATMProject {
    static Scanner inp = new Scanner(System.in);
    static double balance = 1000.00;
    static int pin = 1234;
    static int deposit = 0;
    static double depositTotal = 0;
    static int withdraw = 0;
    static double withdrawTotal = 0;

    public static void main(String[] args) {
        if (login()) {
            menu();
        }
    }

    static boolean login() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter pin: ");
            int enterPin = inp.nextInt();
            if (enterPin == pin) {
                System.out.println("Welcome to the ATM Project!");
                return true;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.println("Wrong pin! Attempt left: " + (3 - attempts) + " of 3!");
                } else {
                    System.out.println("Card locked");
                }
            }
        }
        return false;
    }

    static void menu() {
        int choice;
        do {
            showMenu();
            choice = inp.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    accountTier();
                    break;
                case 5:
                    savingsProjection();
                    break;
                case 6:
                    receiptSummary();
                    break;
                case 7:
                    changePIN();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while(choice != 0);
    }


    static void showMenu() {
        System.out.println("\n1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Account tier ");
        System.out.println("5. Savings projection");
        System.out.println("6. Receipt summary");
        System.out.println("7. Change PIN");
        System.out.println("0. Exit");
        System.out.println("Please enter your choice: ");
    }

    static void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    static void deposit() {
        System.out.println("Please enter deposit amount: ");
        double amount = inp.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero!");
        } else if (amount > 5000) {
            System.out.println("Maximum deposit is 5000!");

        } else {
            balance = balance + amount;

            deposit++;
            depositTotal = depositTotal + amount;

            System.out.printf("Deposited %.2f%n", depositTotal);
        }
    }

    static void withdraw() {
        System.out.println("Please enter withdrawal amount: ");
        double amount = inp.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero!");
        } else if (amount % 10 != 0) {
            System.out.println("Amount must be a multiple of 10!");
        } else if (withdrawTotal + amount > 1000) {
            System.out.println("Session withdrawal limit exceeded!");

        } else {
            double fee;

            if (amount <= 500) {
                fee = 2.00;
            } else {
                fee = 5.00;
            }

            if (balance < amount + fee) {
                System.out.println("Insufficient balance!");
            } else {
                balance = balance - amount - fee;

                withdraw++;
                withdrawTotal = withdrawTotal + amount;

                System.out.printf("Fee: %.2f%n", fee);
                System.out.printf("Withdrawn successful. Balance %.2f%n", withdrawTotal);
            }
        }
    }

    static void accountTier() {
        if (balance < 1000) {
            System.out.println("Tier: Bronze, interest rate: 1%");
        } else if (balance < 5000) {
            System.out.println("Tier: Silver, interest rate: 2%");
        } else if (balance < 20000) {
            System.out.println("Tier: Gold, interest rate: 3%");
        } else {
            System.out.println("Tier: Copper, interest rate: 4%");
        }
    }

    static void savingsProjection() {
        System.out.println("Please enter number of years: ");
        int years = inp.nextInt();

        if (years < 1 || years > 10) {
            System.out.println("Years must be between 1 and 10!");
        } else {
            double rate;

            if (balance < 1000) {
                rate = 0.01;
            } else if (balance < 5000) {
                rate = 0.02;
            } else if (balance < 20000) {
                rate = 0.03;
            } else {
                rate = 0.04;
            }
            double money = balance;

            for (int i = 1; i <= years; i++) {
                money = money + money * rate;

                System.out.printf("Year %d: %.2f%n", i, money);
            }
        }
    }

    static void receiptSummary() {
        System.out.println("Receipt Summary:");
        System.out.printf("Deposits: %d, total: %.2f%n", deposit, depositTotal);
        System.out.printf("Withdraw: %d, total: %.2f%n", withdraw, withdrawTotal);
        System.out.printf("Balance: %.2f%n", balance);
    }

    static void changePIN() {
        System.out.println("Please enter old pin number: ");
        int oldPin = inp.nextInt();

        if (oldPin == pin) {
            System.out.println("Please enter new pin number: ");
            int newPin = inp.nextInt();

            if (newPin < 1000 || newPin > 9999) {
                System.out.println("Pin must be 4 digits!");
            } else {
                System.out.println("Please confirm new pin number: ");
                int confirmPin = inp.nextInt();

                if (newPin == confirmPin) {
                    pin = newPin;
                    System.out.println("PIN changed successfully");
                } else {
                    System.out.println("PIN'S do not match");
                    }
                }
        } else {
                System.out.println("Incorrect old pin number!");
            }

        }
    }