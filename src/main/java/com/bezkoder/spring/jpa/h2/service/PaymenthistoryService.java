package com.bezkoder.spring.jpa.h2.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bezkoder.spring.jpa.h2.model.Account;
import com.bezkoder.spring.jpa.h2.model.Paymenthistory;
import com.bezkoder.spring.jpa.h2.repository.AccountRepository;
import com.bezkoder.spring.jpa.h2.repository.PaymenthistoryRepository;

@Service
public class PaymenthistoryService {
	@Autowired
    private PaymenthistoryRepository paymentRepository;
	
	@Autowired
	AccountRepository AccountRepository;

    public void updatePaymentHistory(long userId, long totalExpenses) {
    System.out.println(userId);
    System.out.println(totalExpenses);
//    System.out.println(date);
        // Retrieve the payment history by user ID
//        Optional<Paymenthistory> optionalPayment = paymentRepository.findById(userId);
    Paymenthistory payment = paymentRepository.findById(userId).orElse(null);
        if (payment==null) {
           
            // Update payment history with new expenses amount and date
        	payment = new Paymenthistory();
            // Set attributes
            payment.setAmount(totalExpenses);
//            payment.setDate(date); 
            // Assuming you have a setUser method in Paymenthistory
            // Also, make sure that this method expects a User object, not just a user ID
             payment.setUser(userId);
            
            // Save the new payment history
            paymentRepository.save(payment);
        }
        else {
        	payment.setAmount(totalExpenses);
//            payment.setDate(date);
            
            // Save the updated payment history
            paymentRepository.save(payment);
        }
}
   
    public void getAccount(long userId) {
        System.out.println(userId);
        
        // Retrieve the account by user ID
        Account account = AccountRepository.findById(userId).orElse(null);
        Paymenthistory payment = paymentRepository.findById(userId).orElse(null);
        if (account != null) {
        	
        	
            // Account exists, retrieve and print its balance
            double balance = account.getBalance(); 
            double expense = payment.getAmount();// Assuming getBalance() method exists in the Account entity
            System.out.println("Account balance for user ID " + userId + ": " + balance);
            if(balance>expense)
            {
            double value = balance-expense;
            System.out.println("remaining balance for user ID " + userId + ": " + value);
            
            account.setBalance((long) value);
            Account updatedAccount = AccountRepository.save(account);
            System.out.println("Updated balance for user ID " + userId + ": " + updatedAccount.getBalance());
            }
            else
            {
            	System.out.println("Account balance for user ID " + userId + "is less")  ;
            	}
        } else {
            // Account doesn't exist for the given user ID
            System.out.println("Account not found for user ID: " + userId);
        }
}
}