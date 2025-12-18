package com.skypay.bankingservice;

import com.skypay.bankingservice.Account;
import java.time.LocalDate;

/**
 * // The BankingApplication class is the main class to demonstrate the use of the banking system
 */
public class BankingApplication {
    public static void main(String[] args) {
        System.out.println("=== Système Bancaire Skypay ===\n");
        
        // Create a new Account object
        Account account = new Account();
        
        try {

            // Operation 1: Deposit of 1000
            account.deposit(1000);
            
            // Operation 1: Deposit of 2000
            account.deposit(2000);
            
           // Operation 3: Withdrawal of 500
            account.withdraw(500);
            
            // Print the bank statement
            account.printStatement();
            
        } catch (Exception e) {
            System.err.println("An error occurred : " + e.getMessage());
        }
    }
}
