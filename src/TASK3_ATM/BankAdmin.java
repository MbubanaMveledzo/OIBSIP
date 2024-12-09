/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TASK3_ATM;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author admin
 */
public class BankAdmin {
    
      private Map<String,UserAccount> accounts;
      
      // Constructor to initialize the bank with an empty accounts map
    public BankAdmin() {
        accounts = new HashMap<>();
    }

    // Method to add a new account to the bank
    public void addAccount(String userId, String pin, double initialBalance) {
        // Creating a new Account object and storing it in the map with userId as the key
        accounts.put(userId, new UserAccount(userId, pin, initialBalance));
    }

    // Method to retrieve an account based on the userId
    public UserAccount getAccount(String userId) {
        return accounts.get(userId);  // Retrieve the Account associated with the userId
    }
    
        // Method to validate user credentials (userId and pin)
    public boolean validateUser(String userId, String pin) {
        UserAccount objAccount = accounts.get(userId);  // Retrieve the account by userId
        return objAccount != null && objAccount.getPin().equals(pin);  // Check if the account exists and pin matches
    }
}


