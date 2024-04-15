package com.bezkoder.spring.jpa.h2.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.spring.jpa.h2.model.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
	 


	@Query("SELECT e.amount,e.date,e.exp_cat_id FROM Expenses e WHERE e.user_id = :userId")
    List<Object[]> findByUserId(@Param("userId") long userId);

}
	

