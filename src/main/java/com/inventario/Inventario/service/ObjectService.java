package com.inventario.Inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.inventario.Inventario.model.Object;
import com.inventario.Inventario.repositories.ObjectRepository;

@Service
public class ObjectService {
	
	@Autowired
	ObjectRepository objRepository;
	
	public List<Object> findAll() {
		return objRepository.findAll();
	}
	
	public ResponseEntity<Object> buscar(Long id) {
		return objRepository.findById(id)
				.map(object -> ResponseEntity.ok(object))
				.orElse(ResponseEntity.notFound().build());
	}
	
	public Object insert(@RequestBody Object object){
		Object result = objRepository.save(object);
		return result;
	}
	
	public ResponseEntity<Object> update( Long id,
			 Object object) {
		if(!objRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		object = objRepository.save(object);
		
		return ResponseEntity.ok(object);
	}
	
	public ResponseEntity<Void> deletad(@PathVariable Long id) {
		if(!objRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		objRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	
	}
}
