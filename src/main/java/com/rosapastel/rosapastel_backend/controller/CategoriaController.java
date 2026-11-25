package com.rosapastel.rosapastel_backend.controller;

import com.rosapastel.rosapastel_backend.entity.Categoria;
import com.rosapastel.rosapastel_backend.service.CategoriaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable Integer id) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);

        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoria);
    }

    @PostMapping
   public ResponseEntity<Categoria> crearCategoria(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.guardarCategoria(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(
        @PathVariable Integer id,
        @Valid @RequestBody Categoria categoria) {

        Categoria existente = categoriaService.buscarCategoriaPorId(id);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setNombreCategoria(categoria.getNombreCategoria());
        existente.setDescripcion(categoria.getDescripcion());
        existente.setEstado(categoria.getEstado());

        return ResponseEntity.ok(categoriaService.guardarCategoria(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Integer id) {
        Categoria existente = categoriaService.buscarCategoriaPorId(id);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}