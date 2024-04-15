package com.bezkoder.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.spring.jpa.h2.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

//	@Query("SELECT a.balance FROM Account a WHERE a.user_id = :userId")
//    List<Account> findByUserId(@Param("userId") long userId);

//List<Account> findByUserId(long user_id);
List<Account> findByUserId(long userId);

    
//    @Query("SELECT a FROM Account a WHERE a.user = :userId")
//    List<Account> findByUserId(@Param("userId") long userId);
}
