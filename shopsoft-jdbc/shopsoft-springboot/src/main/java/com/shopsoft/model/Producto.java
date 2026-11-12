package com.shopsoft.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/** Entidad que representa un registro de la tabla productos. */
@Entity
@Table(name = "productos")
public class Producto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Column(name = "id_categoria")
    private Integer idCategoria = 1;
    @Column(name = "precio", nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    public Integer getIdProducto(){return idProducto;}
    public void setIdProducto(Integer v){idProducto=v;}
    public String getNombre(){return nombre;}
    public void setNombre(String v){nombre=v;}
    public Integer getIdCategoria(){return idCategoria;}
    public void setIdCategoria(Integer v){idCategoria=v;}
    public BigDecimal getPrecio(){return precio;}
    public void setPrecio(BigDecimal v){precio=v;}
    public Integer getCantidad(){return cantidad;}
    public void setCantidad(Integer v){cantidad=v;}
    public LocalDate getFechaVencimiento(){return fechaVencimiento;}
    public void setFechaVencimiento(LocalDate v){fechaVencimiento=v;}
}
