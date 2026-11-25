package com.rosapastel.rosapastel_backend.repository;

import com.rosapastel.rosapastel_backend.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}