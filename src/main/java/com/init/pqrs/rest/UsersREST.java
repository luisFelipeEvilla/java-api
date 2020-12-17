package com.init.pqrs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.pqrs.dao.UsersDAO;
import com.init.pqrs.entitys.Pqr;
import com.init.pqrs.entitys.User;

@RestController
@RequestMapping("/users")
public class UsersREST {
	
	@Autowired
	private UsersDAO usersDAO;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = usersDAO.findAll();
	
		return ResponseEntity.ok(users);
	}
	
	@PostMapping
	public ResponseEntity<User> createPqr(@RequestBody User user) {
		User newUser = usersDAO.save(user);
		
		return ResponseEntity.ok(newUser);
	}
	
	@DeleteMapping(value="{userId}")
	public ResponseEntity<Void> deletePqr(@PathVariable("pqrId") Long userId) {
		usersDAO.deleteById(userId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<User> updatePqr(@RequestBody User user) {
		User updatedUser = usersDAO.save(user);
		
		return ResponseEntity.ok(updatedUser);
	}
}
