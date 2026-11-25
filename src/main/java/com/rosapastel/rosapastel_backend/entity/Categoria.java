package com.rosapastel.rosapastel_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

   @NotBlank(message = "El nombre de la categoría es obligatorio")
@Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
@Column(name = "nombre_categoria", nullable = false, length = 100)
private String nombreCategoria;

   @Size(max = 100, message = "La descripción no puede superar los 100 caracteres")
@Column(name = "descripcion", length = 100)
private String descripcion;

   @NotNull(message = "El estado de la categoría es obligatorio")
@Column(name = "estado", nullable = false)
private Boolean estado;

    public Categoria() {
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}