package com.bezkoder.spring.jpa.h2.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Expenses")


public class Expenses {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "exp_id")
	  private long exp_id;

//	  
	  @Column(name = "user_id")
	  private  long user_id;
	  
	  public Long getExp_cat_id() {
		return exp_cat_id;
	}

	public void setExp_cat_id(Long exp_cat_id) {
		this.exp_cat_id = exp_cat_id;
	}





	@Column(name = "exp_cat_id")
	  private  Long exp_cat_id;
//	  
	  

	  public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}





	@Column(name = "amount")
	  private long amount;
	 
	  @Column(name = "date")
	  private String date;
	 
//	  @ManyToOne(cascade = CascadeType.ALL)
//	  @JoinColumn(name = "user_id")
//	  private User user;
//
//	  @ManyToOne(cascade = CascadeType.ALL)
//	  @JoinColumn(name = "exp_cat")
//	  private Expense_category exp_cat;
	  
	
	  
	  public Expenses() {

	  }

	  public Expenses(long exp_id,long amount,String date,long exp_cat_id) {
//	    this.user_id = user_id;
	    
	    this.exp_id = exp_id;
	    this.amount=amount;
	    this.date=date;
    this.exp_cat_id=exp_cat_id;
	  }

	  

	  public long getExp_id() {
		return exp_id;
	}

	public void setExp_id(long exp_id) {
		this.exp_id = exp_id;
	}

	

	

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	
//	
//	public Expense_category getExp_cat() {
//		return exp_cat;
//	}
//
//	public void setExp_cat(Expense_category exp_cat) {
//		this.exp_cat = exp_cat;
//	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	



//	@Override
//	public String toString() {
//		return "Expenses [exp_id=" + exp_id + ", user_id=" + user + ", exp_Cat_id=" + exp_cat + ", amount="
//				+ amount + ", date=" + date + "]";
//	}

	@Override
	public String toString() {
		return "Expenses [exp_id=" + exp_id + ", user_id=" + user_id + ", exp_cat_id=" + exp_cat_id + ", amount="
				+ amount + ", date=" + date + "]";
	}
	
	}


