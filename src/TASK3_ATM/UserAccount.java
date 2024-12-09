/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TASK3_ATM;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserAccount {

    private String userId;
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;

    // Default Constructor
    public UserAccount() {
        this.userId = "";
        this.pin = "";
        this.balance = 0;

    }
    // Constructor to initialize account details

    public UserAccount(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    // Getters for userId and pin
    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        this.balance += amount;
        this.transactionHistory.add(new Transaction("Deposit", amount)); // Record deposit transaction
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            this.transactionHistory.add(new Transaction("Withdraw", amount)); // Record withdrawal transaction
            return true;
        } else {
            return false;

        }
    }

    // Method to transfer money between accounts
    public boolean transfer(UserAccount targetAccount, double amount) {
        if (this == targetAccount) {

            System.out.println("Error!!, You cannot transfer money to your own account.");
            return false;

        } else {

            if (amount <= balance) {
                this.balance -= amount;
                targetAccount.deposit(amount);
                this.transactionHistory.add(new Transaction("Transfer to " + targetAccount.getUserId(), amount)); // Record transfer
                return true;
            } else {
                return false;
            }

        }
    }

    // Method to print transaction history
    public void printTransactionHistory() {
        // Check if there are any transactions
        if (transactionHistory.isEmpty()) {
             System.out.println("-----------------------------------------------");
            System.out.println("No transactions found.");
        } else {
            System.out.println("-----------------------------------------------");
            System.out.println("Transaction History for " + userId + ":");
            for (Transaction transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

}
