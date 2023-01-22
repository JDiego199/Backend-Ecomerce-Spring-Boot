/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import  javax.persistence.*;

import java.util.Calendar;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mota1
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private float precio;
    
    @Column(name = "precio_fabrica", nullable = false)
    private float precio_fabrica;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "descuento", nullable = false)
    private float descuento;

    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_registro;
    
    @Column(name = "imagen")
    private String [] fileList;

 
    @OneToMany
    private List<Orden_detalles> Orden_detalles;

    @ManyToOne()
    private Cliente_empresa cliente_empresa;

    public Producto(String nombre, String descripcion, float precio, float precio_fabrica, int cantidad, float descuento, Calendar fecha_registro, Cliente_empresa cliente_empresa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.precio_fabrica = precio_fabrica;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.fecha_registro = fecha_registro;
        this.cliente_empresa = cliente_empresa;
    }



    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", precio_fabrica=" + precio_fabrica + ", cantidad=" + cantidad + ", descuento=" + descuento + ", fecha_registro=" + fecha_registro + ", Orden_detalles=" + Orden_detalles + '}';
    }
    
    
}
