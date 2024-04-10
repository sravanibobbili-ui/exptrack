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
//	@GetMapping("/account/{acctid}")
//	  public ResponseEntity<Account> getUserById(@PathVariable("acctid") long id) {
//	    
//	    Optional<Account> actList = AccountRepository.findById(id);
//	    if (actList.isPresent()) {
//	      return new ResponseEntity<>(actList.get(), HttpStatus.OK);
//	    } else {
//	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	  }
	@GetMapping("/account/{userId}")
	  public ResponseEntity<List<Map<String, Object>>> getExpensesByUserId(@PathVariable("userId") long userId) {
	      List<Object[]> AcctData = AccountRepository.findByUserId(userId);
	      List<Map<String, Object>> response = new ArrayList<>();

	      if (!AcctData.isEmpty()) {
	          for (Object[] pair : AcctData) {
	              Map<String, Object> keyValueMap = new LinkedHashMap<>();
	              keyValueMap.put("acct_num", pair[0]);
	              keyValueMap.put("acct_bank_name", pair[1]);
	              keyValueMap.put("payment_mode", pair[2]);
	              keyValueMap.put("branch", pair[3]);
	              keyValueMap.put("balance", pair[4]);
	              keyValueMap.put("user_id", userId);
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
	  
	

	}