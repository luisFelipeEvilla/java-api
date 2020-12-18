package com.init.pqrs.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.pqrs.dao.PqrsDAO;
import com.init.pqrs.dao.UsersDAO;
import com.init.pqrs.entitys.CreatePqrForm;
import com.init.pqrs.entitys.Pqr;
import com.init.pqrs.entitys.User;

@RestController
@RequestMapping("/pqrs")
public class PqrsREST {
	
	@Autowired
	private PqrsDAO pqrsDAO;
	
	@Autowired
	private UsersDAO usersDAO;
	
	@GetMapping
	public ResponseEntity<List<Pqr>> getPqrs() {
		List<Pqr> pqrs = pqrsDAO.findAll();
		
		return ResponseEntity.ok(pqrs);
	}
	
	@RequestMapping(value="{pqrId}")
	public ResponseEntity<Pqr> getPqrById(@PathVariable("pqrId") Long pqrId) {
		Optional<Pqr> optionalPqr = pqrsDAO.findById(pqrId);
		if (optionalPqr.isPresent()) {
			return ResponseEntity.ok(optionalPqr.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Pqr> createPqr(@RequestBody CreatePqrForm pqr) {
		
		Optional<User> optionalUser = usersDAO.findByEmail(pqr.getEmail());
		
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			Long userId = user.getId();
			
			Pqr newPqr = new Pqr();
			
			newPqr.setAsunto(pqr.getAsunto());
			newPqr.setEstado(pqr.getEstado());
			newPqr.setTipo(pqr.getTipo());
			newPqr.setExpired_at(pqr.getExpired_at());
			newPqr.setUser_id(userId);
			
			newPqr = pqrsDAO.save(newPqr);
			
			return ResponseEntity.ok(newPqr);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping(value="{pqrId}")
	public ResponseEntity<Void> deletePqr(@PathVariable("pqrId") Long pqrId) {
		pqrsDAO.deleteById(pqrId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Pqr> updatePqr(@RequestBody Pqr pqr) {
		Pqr updatedPqr = pqrsDAO.save(pqr);
		
		return ResponseEntity.ok(updatedPqr);
	}
}
