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


import com.bezkoder.spring.jpa.h2.repository.ExpensescategoryRepository;
import com.bezkoder.spring.jpa.h2.model.Expense_category;
import com.bezkoder.spring.jpa.h2.model.Expenses;
import com.bezkoder.spring.jpa.h2.model.User;


@RestController
@RequestMapping("/exp")
public class ExpensecategoryController {

	@Autowired
	ExpensescategoryRepository expcatRepository;


	@GetMapping
    public ResponseEntity<List<Expense_category>> getAllExpCat() {
        List<Expense_category> ExpcatList = expcatRepository.findAll();
        return ResponseEntity.ok(ExpcatList);
    }
	 @GetMapping("/cat/{id}")
	  public ResponseEntity<Expense_category> getUserById(@PathVariable("id") long id) {
	    
	    Optional<Expense_category> expcatList = expcatRepository.findById(id);
	    if (expcatList.isPresent()) {
	      return new ResponseEntity<>(expcatList.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @GetMapping("/expcat/{enttype}")
	  public List<Expense_category> getExpenseCategoriesByEnttype(@PathVariable String enttype) {
	    
	   
		  return expcatRepository.findByEnttype(enttype);
	   
	  }
	 
	 @PostMapping("/cat")
	  public ResponseEntity<Expense_category> createexp_cat(@RequestBody Expense_category expcaat) {
	    try
	    {
	    	 Expense_category _exp = expcatRepository.save(expcaat);
//			  new User_details(userdetails.getUser_id_pk(),userdetails.getPassword(), userdetails. getUser_name(),userdetails.getEmail()));
	 return new ResponseEntity<>(_exp, HttpStatus.CREATED);
	} catch (Exception e) {
	 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	    }
	}