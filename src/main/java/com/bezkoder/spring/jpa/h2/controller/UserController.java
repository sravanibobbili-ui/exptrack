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

import com.bezkoder.spring.jpa.h2.model.User;
import com.bezkoder.spring.jpa.h2.repository.AccountRepository;
import com.bezkoder.spring.jpa.h2.repository.UserRepository;
import com.bezkoder.spring.jpa.h2.repository.ExpensesRepository;
import com.bezkoder.spring.jpa.h2.repository.ExpensescategoryRepository;
import com.bezkoder.spring.jpa.h2.repository.PaymenthistoryRepository;
import com.bezkoder.spring.jpa.h2.model.Account;
import com.bezkoder.spring.jpa.h2.model.Expense_category;
import com.bezkoder.spring.jpa.h2.model.Expenses;
import com.bezkoder.spring.jpa.h2.model.Paymenthistory;
import com.bezkoder.spring.jpa.h2.model.Tutorial;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;
 
	
	
	@GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }





  
  
	@GetMapping("/user")
    public ResponseEntity<List<User>> getAllAccount() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }

  
 
  
  @PostMapping("/userdetails")
  public ResponseEntity<User> createUser_details(@RequestBody User user) {
    try {
      User _userdetails = userRepository.save(user);
//    		  new User_details(userdetails.getUser_id_pk(),userdetails.getPassword(), userdetails. getUser_name(),userdetails.getEmail()));
      return new ResponseEntity<>(_userdetails, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/userid/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
    
    Optional<User> userList = userRepository.findById(id);
    if (userList.isPresent()) {
      return new ResponseEntity<>(userList.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


@GetMapping("/user/{username}")
public ResponseEntity<List<Map<String, Object>>> getUsername(@PathVariable("username") String username) {
    List<Object[]> users = userRepository.findByUsername(username);
    List<Map<String, Object>> response = new ArrayList<>();

    if (!users.isEmpty()) {
        for (Object[] pair : users) {
            Map<String, Object> keyValueMap = new LinkedHashMap<>();
            keyValueMap.put("user_id", pair[0]);
            keyValueMap.put("username", pair[1]);
            keyValueMap.put("password", pair[2]);
            response.add(keyValueMap);
        }
        
        // Print key-value pairs in the console
        for (Map<String, Object> keyValueMap : response) {
            System.out.println("users Data:");
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

@PutMapping("/userid/{id}")
public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
  Optional<User> userData = userRepository.findById(id);

  if (userData.isPresent()) {
    User _user = userData.get();
    _user.setUsername(user.getUsername());
    _user.setPassword(user.getPassword());
    _user.setEmail(user.getEmail());
    _user.setFirstname(user.getFirst_name());
    _user.setLastname(user.getLast_name());
    return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
  } else {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
}

