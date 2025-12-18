package com.skypay.bankingservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * // The Account class represents a bank account and provides basic banking operations.
 */
public class Account implements AccountService {
    private int balance;
    private List<Transaction> transactions;
    
    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }
    
    /**
     * The deposit() method is used to deposit an amount into the account.
     * @param amount Amount to deposit
     */
    public void deposit(int amount) {

        try{

            // When the amount is zero or negative
            if (amount <= 0) {
                throw new IllegalArgumentException("The deposit amount must be positive");
            }

            // The transaction date must be the current date
            LocalDate date = LocalDate.now();
            if (date == null) {
                throw new IllegalArgumentException("The date cannot be null");
            }

            balance += amount;
            transactions.add(new Transaction(date, amount, balance));

        } catch (Exception e) {
            System.err.println("An error occurred : " + e.getMessage());
        }

    }
    
    /**
     * The withdraw() method is used to withdraw an amount from the account.
     * @param amount // The amount to be withdrawn
     */
    public void withdraw(int amount) {
        try{

            // When the amount is zero or negative
            if (amount <= 0) {
                throw new IllegalArgumentException("The withdrawal amount must be positive");
            }

            // The transaction date must be the current date
            LocalDate date = LocalDate.now();
            if (date == null) {
                throw new IllegalArgumentException("The date cannot be null");
            }

            // When the account balance is insufficient
            if (balance < amount) {
                throw new IllegalStateException("Insufficient balance to perform this withdrawal");
            }
            
            balance -= amount;
            transactions.add(new Transaction(date, -amount, balance));

        } catch (Exception e) {
            System.err.println("An error occurred : " + e.getMessage());
        }
    }


    /**
    * Prints the bank statement with all transactions.
    * Transactions are displayed from the most recent to the oldest.
    */
    public void printStatement() {
        try{

            System.out.println("DATE || AMOUNT || BALANCE");
            
            // Sort transactions by descending date (most recent first)
            transactions.stream()
                    .sorted(Comparator.comparing(Transaction::getDate).reversed())
                    .forEach(transaction -> System.out.println(transaction.displayTransaction()));
                        
        } catch (Exception e) {
            System.err.println("An error occurred : " + e.getMessage());
        }
    }
    
}