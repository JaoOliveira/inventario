package com.inventario.Inventario.controller;

import java.util.List;

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

import com.inventario.Inventario.model.Departament;
import com.inventario.Inventario.repositories.DepartamentRepository;

@RestController
@RequestMapping("/departamet")
public class DepartamentController {
	
	@Autowired
	private DepartamentRepository repository;
	
	@GetMapping
	public List<Departament> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Departament> findById(@PathVariable Long id){
		return repository.findById(id)
				.map(departament -> ResponseEntity.ok(departament))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Departament insert(@RequestBody Departament departament){
		Departament result = repository.save(departament);
		return result;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Departament> atualizar(@PathVariable Long id,
			@RequestBody Departament departament) {
		if(!repository.existsById(id)) {
					return ResponseEntity.notFound().build();
				}
		departament = repository.save(departament);
		
		return ResponseEntity.ok(departament);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if(!repository.existsById(id)) {
					return ResponseEntity.notFound().build();
				}
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();

	}
}

