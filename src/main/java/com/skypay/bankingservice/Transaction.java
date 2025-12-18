package com.skypay.bankingservice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * // The 'Transaction' class represents a bank transaction, including the transaction date, amount, and balance after the transaction.
 */
public class Transaction {
    private LocalDate date;
    private int amount;
    private int balance;
    
    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Transaction(LocalDate date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public int getBalance() {
        return balance;
    }
    
    /**
     * Formats the transaction for display in the bank statement.
    */
    public String displayTransaction() {
        String formattedDate = date.format(DATE_FORMATTER);
        return String.format("%s || %d || %d", formattedDate, amount, balance);
    }
}