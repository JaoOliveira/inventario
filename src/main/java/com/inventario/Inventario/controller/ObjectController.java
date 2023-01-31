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
import com.inventario.Inventario.service.ObjectService;


@RestController
@RequestMapping("/Object")
public class ObjectController {
	
	@Autowired
	private ObjectService objService;
	
	@GetMapping
	public List<Object> findAll(){
		 return objService.findAll();
		 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscar(@PathVariable Long id) {
		return objService.buscar(id);
	}
	
	@PostMapping
	public Object insert(@RequestBody Object object){
		return objService.insert(object);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody Object object) {
		return objService.update(id, object);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		return objService.deletad(id);
	}
	
}
