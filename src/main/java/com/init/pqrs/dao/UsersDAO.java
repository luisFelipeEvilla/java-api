package com.init.pqrs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.pqrs.entitys.User;

public interface UsersDAO extends JpaRepository<User, Long>{
		
}
