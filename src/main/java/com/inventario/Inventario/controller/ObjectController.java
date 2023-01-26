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

import com.inventario.Inventario.model.Object;
import com.inventario.Inventario.repositories.ObjectRepository;


@RestController
@RequestMapping("/Object")
public class ObjectController {
	
	@Autowired
	private ObjectRepository repository;
	
	@GetMapping
	public List<Object> findAll(){
		List<Object> result = repository.findAll();
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscar(@PathVariable Long id) {
		return repository.findById(id)
				.map(object -> ResponseEntity.ok(object))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Object insert(@RequestBody Object object){
		Object result = repository.save(object);
		return result;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable Long id,
			@RequestBody Object object) {
		if(!repository.existsById(id)) {
					return ResponseEntity.notFound().build();
				}
		object = repository.save(object);
		
		return ResponseEntity.ok(object);
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
