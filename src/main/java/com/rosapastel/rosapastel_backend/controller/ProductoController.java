package com.rosapastel.rosapastel_backend.controller;

import com.rosapastel.rosapastel_backend.entity.Producto;
import com.rosapastel.rosapastel_backend.service.ProductoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Integer id) {
        Producto producto = productoService.buscarProductoPorId(id);

        if (producto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@Valid @RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.guardarProducto(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable Integer id,
            @Valid @RequestBody Producto producto) {
        Producto existente = productoService.buscarProductoPorId(id);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setNombreProducto(producto.getNombreProducto());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        existente.setCategoria(producto.getCategoria());
        existente.setEstado(producto.getEstado());

        return ResponseEntity.ok(productoService.guardarProducto(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        Producto existente = productoService.buscarProductoPorId(id);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}