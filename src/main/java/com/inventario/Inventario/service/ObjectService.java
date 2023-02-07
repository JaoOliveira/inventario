package com.inventario.Inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.inventario.Inventario.model.Object;
import com.inventario.Inventario.repositories.ObjectRepository;
import com.inventario.Inventario.service.exception.EntityNotFoundException;

import jakarta.validation.Valid;

@Service
public class ObjectService {
	
	@Autowired
	private ObjectRepository objRepository;
	
	public List<Object> findAll(){
		return objRepository.findAll();
	}
	
	public ResponseEntity<Object> findById(Long id){
		return objRepository.findById(id)
				.map(object -> ResponseEntity.ok(object))
				.orElseThrow(()-> new EntityNotFoundException("Id not found " + id ));
	}
	
	public Object insert(@RequestBody Object object){
		Object result = objRepository.save(object);
		return result;
	}
	
	public ResponseEntity<Object> update(@Valid Long id,@RequestBody Object newobject) {
		Optional<Object> object = objRepository.findById(id);
	    if (!objRepository.existsById(id)) {
	      return ResponseEntity.notFound().build();
	    }
	    Object objAtualizado = object.get();
	    objAtualizado.setName(newobject.getName());
	    objAtualizado.setModel(newobject.getModel());
	    objAtualizado.setSerialNumber(newobject.getSerialNumber());
	    objAtualizado.setDepartament(newobject.getDepartament());
	    objRepository.save(objAtualizado);
	    return ResponseEntity.noContent().build();
	  }
	
	public ResponseEntity<Void> deletad(@PathVariable Long id) {
		if(!objRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		objRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	
	}
}
