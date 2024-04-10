package com.bezkoder.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.spring.jpa.h2.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("SELECT a.acct_num,a.acc_bank_name,a.payment_mode,a.branch,a.balance FROM Account a WHERE a.user_id = :userId")
    List<Object[]> findByUserId(@Param("userId") long userId);
}
