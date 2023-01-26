package com.inventario.Inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.Inventario.model.Departament;

public interface DepartamentRepository extends JpaRepository<Departament, Long>{
	
}
