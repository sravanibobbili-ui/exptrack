package com.bezkoder.spring.jpa.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.spring.jpa.h2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u.user_id,u.username,u.password FROM User u WHERE u.username = :username")
//    List<Object[]> findByUsername(@Param("username") String username);

	List<Object[]> findByUsername(@Param("username")String username);
}
