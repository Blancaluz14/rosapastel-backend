package com.rosapastel.rosapastel_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @NotBlank(message = "El nombre del producto es obligatorio")
@Size(max = 80, message = "El nombre del producto no puede superar los 80 caracteres")
@Column(name = "nombre_producto", nullable = false, length = 80)
private String nombreProducto;

    @NotNull(message = "El precio del producto es obligatorio")
@PositiveOrZero(message = "El precio no puede ser negativo")
@Column(name = "precio", nullable = false, precision = 10, scale = 2)
private BigDecimal precio;

   @NotNull(message = "El stock del producto es obligatorio")
@PositiveOrZero(message = "El stock no puede ser negativo")
@Column(name = "stock", nullable = false)
private Integer stock;

    @NotNull(message = "Debe seleccionar una categoría para el producto")
@ManyToOne
@JoinColumn(name = "id_categoria", nullable = false)
private Categoria categoria;

@NotNull(message = "El estado del producto es obligatorio")
@Column(name = "estado", nullable = false)
private Boolean estado;
    public Producto() {
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}