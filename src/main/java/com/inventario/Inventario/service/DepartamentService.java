package com.inventario.Inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventario.Inventario.model.Departament;
import com.inventario.Inventario.repositories.DepartamentRepository;


@Service
public class DepartamentService {
	
	@Autowired
	DepartamentRepository repository;
	
	public List<Departament> findAll(){
		return repository.findAll();
		
	}
	
	public ResponseEntity<Departament> findById(Long id) {
		return repository.findById(id)
		.map(departament -> ResponseEntity.ok(departament))
		.orElse(ResponseEntity.notFound().build());
	}
	
	public Departament insert(Departament departament){
		Departament result = repository.save(departament);
		return result;
	}
	
	public ResponseEntity<Departament> update(Long id, Departament departament) {
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
			}
		departament = repository.save(departament);
	
		return ResponseEntity.ok(departament);	
	}
	
	public ResponseEntity<Void> deletad(Long id) {
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
			}
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
