/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TASK3_ATM;

/**
 *
 * @author admin
 */
public class Transaction {

    private String type;
    private double amount;

    public Transaction(String type, double amount) {

        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + " of amount: $" + amount;
    }
}
