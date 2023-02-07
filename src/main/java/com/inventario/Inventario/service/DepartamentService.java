package com.inventario.Inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventario.Inventario.model.Departament;
import com.inventario.Inventario.repositories.DepartamentRepository;
import com.inventario.Inventario.service.exception.EntityNotFoundException;


@Service
public class DepartamentService {
	
	@Autowired
	DepartamentRepository repository;
	
	public List<Departament> buscarTodos(){
		return repository.findAll();	
	}
	
	public ResponseEntity<Departament> findById(Long id) {
		return repository.findById(id)
		.map(departament -> ResponseEntity.ok(departament))
		.orElseThrow(()-> new EntityNotFoundException("Id not found " + id ));
	}
	
	public Departament insert(Departament departament){
		Departament result = repository.save(departament);
		return result;
	}
	
}
