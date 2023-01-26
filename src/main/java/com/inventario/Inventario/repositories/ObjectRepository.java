package com.inventario.Inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.Inventario.model.Object;

public interface ObjectRepository extends JpaRepository<Object, Long> {

}
