package com.bezkoder.spring.jpa.h2.controller;
import java.util.ArrayList;
import java.util.List;
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
import com.bezkoder.spring.jpa.h2.repository.ExpensesRepository;
import com.bezkoder.spring.jpa.h2.repository.PaymenthistoryRepository;
import com.bezkoder.spring.jpa.h2.repository.UserRepository;
import com.bezkoder.spring.jpa.h2.model.Account;
import com.bezkoder.spring.jpa.h2.model.Expense_category;
import com.bezkoder.spring.jpa.h2.model.Expenses;
import com.bezkoder.spring.jpa.h2.model.Paymenthistory;
import com.bezkoder.spring.jpa.h2.model.User;


@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymenthistoryRepository paymentRepository;
	
	@Autowired
	UserRepository userRepository;
 
	
	@Autowired
	ExpensesRepository expRepository;

	@GetMapping
    public ResponseEntity<List<Paymenthistory>> getAllAccount() {
        List<Paymenthistory> AccountList = paymentRepository.findAll();
        return ResponseEntity.ok(AccountList);
    }

	@PostMapping("/details")
	  public ResponseEntity<Paymenthistory> createUser_details(@RequestBody Paymenthistory payment) {
	    try {
	    	
;	     Paymenthistory _payment = paymentRepository.save(payment);
//	    		  new User_details(userdetails.getUser_id_pk(),userdetails.getPassword(), userdetails. getUser_name(),userdetails.getEmail()));
	      return new ResponseEntity<>(_payment, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}

	