package com.bezkoder.spring.jpa.h2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.h2.model.Expense_category;

public interface ExpensescategoryRepository extends JpaRepository<Expense_category, Long> {

	Optional<Expense_category> findById(long id);
	List<Expense_category>findByEnttype(String enttype);

}
