package com.bezkoder.spring.jpa.h2.model;

import jakarta.persistence.*;
@Entity
@Table(name = "Account")
public class Account {

	 @Id
	@Column(name = "acct_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long acct_id;

 
  @Column(name = "acct_num")
  private long acct_num;

  @Column(name = "acc_bank_name")
  private String acc_bank_name;

  @Column(name = "payment_mode")
  private String payment_mode;

  @Column(name = "branch")
  private String branch;
  
  
  @Column(name = "balance")
  private long balance;
  
  @Column(name = "user_id")
  private  long user_id;
  
  
  public long getAcct_num() {
	return acct_num;
}

public void setAcct_num(long acct_num) {
	this.acct_num = acct_num;
}



public long getUser_id() {
	return user_id;
}

public void setUser_id(long user_id) {
	this.user_id = user_id;
}

public Account() {

  }

  public Account(long acct_id,long acct_num,String acc_bank_name, String payment_mode, String branch,long balance) {
   
    this.acct_id = acct_id;
    this.acc_bank_name = acc_bank_name;
    this.payment_mode=payment_mode;
    this.branch=branch;
    this.balance=balance;
  }

  

  



public long getAcct_id() {
	return acct_id;
}

public void setAcct_id(long acct_id) {
	this.acct_id = acct_id;
}

public String getAcc_bank_name() {
	return acc_bank_name;
}

public void setAcc_bank_name(String acc_bank_name) {
	this.acc_bank_name = acc_bank_name;
}

public String getPayment_mode() {
	return payment_mode;
}

public void setPayment_mode(String payment_mode) {
	this.payment_mode = payment_mode;
}

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}

public long getBalance() {
	return balance;
}

public void setBalance(long balance) {
	this.balance = balance;
}

@Override
public String toString() {
	return "Account [acct_id=" + acct_id + ", acct_num=" + acct_num + ", acc_bank_name=" + acc_bank_name
			+ ", payment_mode=" + payment_mode + ", branch=" + branch + ", balance=" + balance + ", user_id=" + user_id
			+ "]";
}

}
