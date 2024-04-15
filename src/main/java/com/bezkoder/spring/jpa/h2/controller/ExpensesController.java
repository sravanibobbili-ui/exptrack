package com.bezkoder.spring.jpa.h2.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jpa.h2.model.Account;
import com.bezkoder.spring.jpa.h2.model.Expense_category;
import com.bezkoder.spring.jpa.h2.model.Expenses;
import com.bezkoder.spring.jpa.h2.model.Paymenthistory;
import com.bezkoder.spring.jpa.h2.model.Tutorial;
import com.bezkoder.spring.jpa.h2.model.User;
import com.bezkoder.spring.jpa.h2.repository.AccountRepository;
import com.bezkoder.spring.jpa.h2.repository.ExpensesRepository;
import com.bezkoder.spring.jpa.h2.repository.ExpensescategoryRepository;
import com.bezkoder.spring.jpa.h2.repository.PaymenthistoryRepository;
import com.bezkoder.spring.jpa.h2.repository.UserRepository;
import com.bezkoder.spring.jpa.h2.service.PaymenthistoryService;
@RestController
@RequestMapping("/expense")
public class ExpensesController {

  @Autowired
  ExpensesRepository expRepository;
 
  @Autowired
  private PaymenthistoryRepository paymentRepository;
  
  @Autowired
	AccountRepository AccountRepository;
	
//  @Autowired
//   private PaymenthistoryService paymentService;
  @Autowired
  private PaymenthistoryService paymentService;
  
  @GetMapping
  public ResponseEntity<List<Expenses>> getAllExp() {
      List<Expenses> exp = expRepository.findAll();
      return ResponseEntity.ok(exp);
  }

  @PostMapping("/expenses")
  public ResponseEntity<Expenses> createTutorial(@RequestBody Expenses exp) {
    try
    {
    	 Expenses _exp = expRepository.save(exp);
//		  new User_details(userdetails.getUser_id_pk(),userdetails.getPassword(), userdetails. getUser_name(),userdetails.getEmail()));
 return new ResponseEntity<>(_exp, HttpStatus.CREATED);
} catch (Exception e) {
 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
}
    }

  

  
  @GetMapping("/expense/{id}")
  public ResponseEntity<Expenses> getUserById(@PathVariable("id") long id) {
    
    Optional<Expenses> expList = expRepository.findById(id);
    if (expList.isPresent()) {
      return new ResponseEntity<>(expList.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
//  @GetMapping("/exp/{userId}")
//  public ResponseEntity<List<Object[]>> getExpensesByUserId(@PathVariable("userId") long userId) {
//      List<Object[]> expensesData = expRepository.findByUserId(userId);
//
//      if (!expensesData.isEmpty()) {
//          for (Object[] row : expensesData) {
//              for (Object element : row) {
//                  System.out.print(element + "\t");
//              }
//              System.out.println(); // Move to the next line after printing each row
//          }
//          return new ResponseEntity<>(expensesData, HttpStatus.OK);
//      } else {
//          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//      }
//  }
//  
//  to get the value in key-pair
  
  @GetMapping("/exp/{userId}")
  public ResponseEntity<List<Map<String, Object>>> getExpensesByUserId(@PathVariable("userId") long userId) {
      List<Object[]> expensesData = expRepository.findByUserId(userId);
      List<Map<String, Object>> response = new ArrayList<>();

      if (!expensesData.isEmpty()) {
          for (Object[] pair : expensesData) {
              Map<String, Object> keyValueMap = new LinkedHashMap<>();
              keyValueMap.put("amount", pair[0]);
              keyValueMap.put("date", pair[1]);
              keyValueMap.put("exp_cat_id", pair[2]);
//              keyValueMap.put("user_id", userId);
              response.add(keyValueMap);
          }
          
          // Print key-value pairs in the console
          for (Map<String, Object> keyValueMap : response) {
              System.out.println("Expense Data:");
              for (Map.Entry<String, Object> entry : keyValueMap.entrySet()) {
                  System.out.println(entry.getKey() + ": " + entry.getValue());
              }
              System.out.println(); // Add a newline for better readability
          }
          
          return new ResponseEntity<>(response, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }
  
//   sum the exp-amount
//  @GetMapping("/totalexp/{userId}")
//  public ResponseEntity<Map<String, Object>> getExpenseByUserId(@PathVariable("userId") long userId) {
//      List<Object[]> expensesData = expRepository.findByUserId(userId);
//      Map<String, Object> response = new HashMap<>();
//
//      if (!expensesData.isEmpty()) {
//    	  List<Map<String, Object>> expenseList = new ArrayList<>();
//          long totalExpenses = 0; // Variable to store the total expense amount
//          for (Object[] pair : expensesData) {
//              Map<String, Object> keyValueMap = new LinkedHashMap<>();
//              keyValueMap.put("exp_amount", pair[0]);
//              keyValueMap.put("exp_date", pair[1]);
//              keyValueMap.put("exp_cat", pair[2]);
//              expenseList.add(keyValueMap);
//              
//              // Add the current expense amount to the total
//              totalExpenses += (long) pair[0];
//          }
//          // Include the total expense amount in the response
//          response.put("expense_data", expenseList);
//          response.put("total_expenses", totalExpenses);
//          updatePaymentHistoryAmount(userId, totalExpenses);
//          // Print key-value pairs in the console
//          System.out.println("Expense Data:");
//          for (Map.Entry<String, Object> entry : response.entrySet()) {
//              System.out.println(entry.getKey() + ": " + entry.getValue());
//          }
//          System.out.println(); // Add a newline for better readability
//
//          return new ResponseEntity<>(response, HttpStatus.OK);
//      } else {
//          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//      }
//  }
//  private void updatePaymentHistoryAmount(long userId, long totalExpenses) {
//	    Optional<Paymenthistory> paymentHistoryOptional = paymentRepository.findById(userId);
//	    if (paymentHistoryOptional.isPresent()) {
//	        Paymenthistory paymentHistory = paymentHistoryOptional.get();
//	        paymentHistory.setAmount(totalExpenses);
//	        paymentRepository.save(paymentHistory); // Save the updated payment history
//	    } else {
//	        // Handle case where payment history for userId is not found
//	        // You may choose to create a new payment history entry here or handle it as per your application logic
//	    }
//	}
  
  @GetMapping("/totalexp/{userId}")
  public ResponseEntity<Map<String, Object>> getExpensesByUserId1(@PathVariable("userId") long userId) {
      List<Object[]> expensesData = expRepository.findByUserId(userId);
      Map<String, Object> response = new HashMap<>();

      if (!expensesData.isEmpty()) {
    	  List<Map<String, Object>> expenseList = new ArrayList<>();
          long totalExpenses = 0; // Variable to store the total expense amount
          for (Object[] pair : expensesData) {
              Map<String, Object> keyValueMap = new LinkedHashMap<>();
              keyValueMap.put("amount", pair[0]);
              keyValueMap.put("date", pair[1]);
              keyValueMap.put("exp_cat_id", pair[2]);
              expenseList.add(keyValueMap);
              
              // Add the current expense amount to the total
              totalExpenses += (long) pair[0];
          }
          // Include the total expense amount in the response
          response.put("expense_data", expenseList);
          response.put("total_expenses", totalExpenses);
////          paymentservice.updatePaymentHistory(userId, totalExpenses,date);
//          // Print key-value pairs in the console
          System.out.println("Expense Data:");
         for (Map.Entry<String, Object> entry : response.entrySet()) {
             System.out.println(entry.getKey() + ": " + entry.getValue());
         }
          System.out.println(); // Add a newline for better readability
       paymentService.updatePaymentHistory(userId, totalExpenses);
//      paymentService.getAccount(userId);
          return new ResponseEntity<>(response, HttpStatus.OK);
         
          
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }
//  
//  @GetMapping("/account/{userId}")
//  public ResponseEntity<Map<String, Object>> getAccountDetails(@PathVariable("userId") long userId) {
//      Map<String, Object> accountDetails = new HashMap<>();
//
//      // Retrieve the account balance by user ID
//      List<Account> balanceList = AccountRepository.findByUserId(userId);
//      Optional<Paymenthistory> paymentHistoryOptional = paymentRepository.findByUserId(userId);
//
//      if (!balanceList.isEmpty() && paymentHistoryOptional.isPresent()) {
//          Object[] accountData = balanceList.get(0);
//          double balance = ((Number) accountData[0]).doubleValue(); // Assuming balance is at index 0
//
//          // Calculate total expenses from payment history
//          Paymenthistory paymentHistory = paymentHistoryOptional.get();
//          double totalExpenses = paymentHistory.getAmount();
//
//          double remainingBalance = balance - totalExpenses;
//
//          accountDetails.put("balance", balance);
//          accountDetails.put("totalExpenses", totalExpenses);
//          accountDetails.put("remainingBalance", remainingBalance);
//
//          return new ResponseEntity<>(accountDetails, HttpStatus.OK);
//      } else {
//          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//      }
//  }
//
  
  @GetMapping("/account/{userId}")
  public ResponseEntity<Map<String, Object>> getAccountDetails(@PathVariable("userId") long userId) {
      Map<String, Object> accountDetails = new HashMap<>();

      // Retrieve the account balance by user ID
      List<Account> accounts = AccountRepository.findByUserId(userId);
      if (!accounts.isEmpty()) {
          double totalBalance = 0;
          for (Account account : accounts) {
              totalBalance += account.getBalance();
          }

          // Get total expenses from payment history (assuming you have a repository for PaymentHistory)
          Optional<Paymenthistory> paymentHistoryOptional = paymentRepository.findByUserId(userId);
          double totalExpenses = paymentHistoryOptional.map(Paymenthistory::getAmount).orElse((long) 0.0);

          double remainingBalance = totalBalance - totalExpenses;

          accountDetails.put("totalBalance", totalBalance);
//          accountDetails.put("totalExpenses", totalExpenses);
          accountDetails.put("remainingBalance", remainingBalance);

          return new ResponseEntity<>(accountDetails, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }


 }
  
  


