package com.init.pqrs.dao;

import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.init.pqrs.entitys.User;

public interface UsersDAO extends JpaRepository<User, Long>{
		@Query("SELECT u FROM User u WHERE u.email = :email")
		Optional<User> findByEmail(@Param("email") String email);
}
