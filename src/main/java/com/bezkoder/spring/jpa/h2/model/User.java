package com.bezkoder.spring.jpa.h2.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "usertable")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private long user_id;

  @Column(name = "username")
  private String username;

  @Column(name = "firstname")
  private String firstname;

  
  @Column(name = "lastname")
  private String lastname;

  
  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;
  

public User() {

  }

  public User(long user_id,String username,String firstname,String lastname, String password, String email) {
    this.user_id = user_id;
    this.username = username;
    this.firstname = firstname;
    this.lastname = lastname;
    this.password = password;
    this.email=email;
  
  }

  

  public String getFirst_name() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLast_name() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public long getUser_id() {
	return user_id;
}

public void setUser_id(long user_id) {
	this.user_id = user_id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


@Override
public String toString() {
	return "User [user_id=" + user_id + ", username=" + username + ", firstname=" + firstname + ", lastname="
			+ lastname + ", password=" + password + ", email=" + email + "]";
}

}
