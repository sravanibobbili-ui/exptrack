package com.bezkoder.spring.jpa.h2.controller;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.bezkoder.spring.jpa.h2.repository.AccountRepository;
import com.bezkoder.spring.jpa.h2.repository.UserRepository;
import com.bezkoder.spring.jpa.h2.model.Account;
import com.bezkoder.spring.jpa.h2.model.Expense_category;
import com.bezkoder.spring.jpa.h2.model.Expenses;
import com.bezkoder.spring.jpa.h2.model.User;


@RestController
@RequestMapping("/get")
public class AccountController {

	@Autowired
	AccountRepository AccountRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping
    public ResponseEntity<List<Account>> getAllAccount() {
        List<Account> AccountList = AccountRepository.findAll();
        return ResponseEntity.ok(AccountList);
    }

	@PostMapping("/account")
	  public ResponseEntity<Account> createUser_details(@RequestBody Account account) {
	    try {
	     Account _account = AccountRepository.save(account);
//	    		  new User_details(userdetails.getUser_id_pk(),userdetails.getPassword(), userdetails. getUser_name(),userdetails.getEmail()));
	      return new ResponseEntity<>(account, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	@PostMapping("/addaccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account accountRequest) {
        try {
            // Create a new Account entity from the request data
            Account account = new Account();
            account.setAcc_bank_name(accountRequest.getAcc_bank_name());
            account.setPayment_mode(accountRequest.getPayment_mode());
            account.setBranch(accountRequest.getBranch());
            account.setBalance(accountRequest.getBalance());
            account.setUser_id(accountRequest.getUser_id());
            account.setAcct_num(accountRequest.getAcct_num());

            // Save the account using the repository
            Account createdAccount = AccountRepository.save(account);

            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            // If an error occurs, return an internal server error response
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@GetMapping("/account/{userId}")
	public ResponseEntity<List<Map<String, Object>>> getAccountsByUserId(@PathVariable("userId") long userId) {
	    List<Account> accounts = AccountRepository.findByUserId(userId);
	    List<Map<String, Object>> response = new ArrayList<>();

	    if (!accounts.isEmpty()) {
	        for (Account account : accounts) {
	            Map<String, Object> accountMap = new LinkedHashMap<>();
	            accountMap.put("acct_num", account.getAcct_num());
	            accountMap.put("acct_bank_name", account.getAcc_bank_name());
	            accountMap.put("payment_mode", account.getPayment_mode());
	            accountMap.put("branch", account.getBranch());
	            accountMap.put("balance", account.getBalance());
	            accountMap.put("user_id", account.getUser_id());
	            response.add(accountMap);
	        }
	        
	        // Print key-value pairs in the console
	        for (Map<String, Object> accountMap : response) {
	            System.out.println("Account Data:");
	            for (Map.Entry<String, Object> entry : accountMap.entrySet()) {
	                System.out.println(entry.getKey() + ": " + entry.getValue());
	            }
	            System.out.println(); // Add a newline for better readability
	        }
	        
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}


	}