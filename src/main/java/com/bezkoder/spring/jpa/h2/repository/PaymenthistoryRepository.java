package com.bezkoder.spring.jpa.h2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.spring.jpa.h2.model.Paymenthistory;

public interface PaymenthistoryRepository extends JpaRepository<Paymenthistory,Long> {

	@Query("SELECT p FROM Paymenthistory p WHERE p.user = :userId")
    Optional<Paymenthistory> findByUserId(@Param("userId") long userId);
}
