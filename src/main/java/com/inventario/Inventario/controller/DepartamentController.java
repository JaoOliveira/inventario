package com.inventario.Inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.Inventario.model.Departament;
import com.inventario.Inventario.service.DepartamentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departamet")
public class DepartamentController {
	
	@Autowired
	private DepartamentService depService;
	
	@GetMapping
	public List<Departament> findAll(){
		return depService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Departament> findById(@PathVariable Long id){
		return depService.findById(id);
	}
	
	@PostMapping
	public Departament insert(@Valid @RequestBody Departament departament){
		return depService.insert(departament);	
	}
	
}

