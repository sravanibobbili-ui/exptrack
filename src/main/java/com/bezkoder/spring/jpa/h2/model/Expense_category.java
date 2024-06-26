package com.bezkoder.spring.jpa.h2.model;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "expense_category")
public class Expense_category {
      
	   @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "exp_cat_id")
	  private long exp_id;
      
    public long getExp_cat_id() {
		return exp_id;
	}

	public void setExp_cat_id(long exp_cat_id) {
		this.exp_id = exp_cat_id;
	}


    @Column(name = "enttype")
    private String enttype;

  

    public Expense_category() {
    }



    public Expense_category(long exp_cat_id,  String enttype) {
		super();
		this.exp_id = exp_cat_id;
//		this.exp_cat = exp_cat;
		this.enttype = enttype;
//		this.ent = ent;
	}



    public String getEnttype() {
        return enttype;
    }

    public void setEnttype(String enttype) {
        this.enttype = enttype;
    }



    @Override
	public String toString() {
		return "Expense_category [exp_cat_id=" + exp_id + ", enttype=" + enttype + "]";
	}

	
}