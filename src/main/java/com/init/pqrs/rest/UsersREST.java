package com.init.pqrs.rest;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.pqrs.dao.UsersDAO;
import com.init.pqrs.entitys.LoginData;
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
	
	@RequestMapping(value="/signin", method = RequestMethod.POST)
	public ResponseEntity<User> signin(@RequestBody LoginData user) {
		Optional<User> optionalUserDB = usersDAO.findByEmail(user.getEmail());
		
		if (optionalUserDB.isPresent()) {
			User userDB = optionalUserDB.get();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
			
			if (encoder.matches(user.getPassword(), userDB.getPassword())) {
				return ResponseEntity.ok(userDB);
			} else {
				return ResponseEntity.noContent().build();
			}
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ResponseEntity<User> signup(@RequestBody User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		
		String encodedPass = encoder.encode(user.getPassword());
		user.setPassword(encodedPass);
		User newUser = usersDAO.save(user);
		
		return ResponseEntity.ok(newUser);
	}
	
	@DeleteMapping(value="{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("pqrId") Long userId) {
		usersDAO.deleteById(userId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updatedUser = usersDAO.save(user);
		
		return ResponseEntity.ok(updatedUser);
	}
}
