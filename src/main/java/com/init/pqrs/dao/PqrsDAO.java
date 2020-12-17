package com.init.pqrs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.pqrs.entitys.Pqr;

public interface PqrsDAO extends JpaRepository<Pqr, Long>{

}
