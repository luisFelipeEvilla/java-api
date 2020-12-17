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
import com.init.pqrs.entitys.Pqr;

@RestController
@RequestMapping("/pqrs")
public class PqrsREST {
	
	@Autowired
	private PqrsDAO pqrsDAO;
	
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
	public ResponseEntity<Pqr> createPqr(@RequestBody Pqr pqr) {
		Pqr newPqr = pqrsDAO.save(pqr);
		
		return ResponseEntity.ok(newPqr);
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
