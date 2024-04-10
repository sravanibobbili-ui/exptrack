package com.bezkoder.spring.jpa.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "paymenthistory")
public class Paymenthistory {

//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  @Column(name = "payment_id")
//  private long payment_id;
//  
  

  @Column(name = "exp_date")
  private String date;

  
  @Column(name = "exp_amount")
  private long amount;

//  @OneToOne(cascade = CascadeType.ALL)
  @Id
  
  @Column(name = "user_id")
  private long user;

//public long getPayment_id() {
//	return payment_id;
//}
//
//public void setPayment_id(long payment_id) {
//	this.payment_id = payment_id;
//}
//


public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public long getAmount() {
	return amount;
}

public void setAmount(long amount) {
	this.amount = amount;
}

public long getUser() {
	return user;
}

public void setUser(long user) {
	this.user= user;
}

@Override
public String toString() {
	return "Paymenthistory [ date=" + date + ", amount=" + amount
			+ ", user_id=" + user+ "]";
}
  
}
  
 