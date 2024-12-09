/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TASK3_ATM;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ATM_User {

    private static BankAdmin bank = new BankAdmin();
    private static Scanner objScanner = new Scanner(System.in);

    private static UserAccount login() {
        System.out.print("Enter User ID: ");
        String userId = objScanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = objScanner.nextLine();

        if (bank.validateUser(userId, pin)) {
            return bank.getAccount(userId);
        } else {
            System.out.println("Invalid credentials. Please try again.");
            return login();  // Recursive login attempt
        }
    }

    private static void Menu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.print("Please select an option: ");
    }

    public static void main(String[] args) {
        //adding users to the bank
        bank.addAccount("user1", "1234", 5000.00);
        bank.addAccount("user2", "5678", 3000.00);

        System.out.println("Welcome to the Standard Banking System!");

        // Login process
        UserAccount currentAccount = login();
        System.out.println("Your Account Balance: $" + currentAccount.getBalance());
        boolean quit = false;
        while (!quit) {

            Menu();
            int choice = objScanner.nextInt();
            objScanner.nextLine();

            switch (choice) {
                case 1:

                    currentAccount.printTransactionHistory();

                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = objScanner.nextDouble();
                    if (currentAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Your new balance is: $" + currentAccount.getBalance());

                    } else {
                        System.out.println("Insufficient balance.");
                        System.out.println("Your Account Balance: $" + currentAccount.getBalance());
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = objScanner.nextDouble();
                    currentAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. Your new balance is: $" + currentAccount.getBalance());
                    break;
                case 4:
                    System.out.print("Enter the recipient's user ID: ");
                    String targetUserId = objScanner.nextLine();
                    UserAccount targetAccount = bank.getAccount(targetUserId);

                    if (targetAccount != null) {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = objScanner.nextDouble();
                        if (currentAccount.transfer(targetAccount, transferAmount)) {
                            System.out.println("Transfer successful. Your new balance is: $" + currentAccount.getBalance());
                        } else {
                            System.out.println("Insufficient balance.");
                            System.out.println("Your Account Balance: $" + currentAccount.getBalance());
                        }
                    } else {
                        System.out.println("Recipient account not found.");
                    }
                    break;
                case 5:
                    quit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }

        }
    }
}
