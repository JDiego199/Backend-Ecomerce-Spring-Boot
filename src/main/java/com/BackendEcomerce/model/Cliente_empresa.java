/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import javax.persistence.*;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mota1
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente_empresa")
public class Cliente_empresa {

    @Id
    @Column(name = "cliente_id")
    private Integer id_empresa;

    @Column(name = "dni_ruc", nullable = false)
    private String dni_ruc;
    @Column(name = "razon_social", nullable = false)
    private String razon_social;
    @Column(name = "nombre_comercial", nullable = false)
    private String nombre_comercial;
    @Column(name = "reputacion", nullable = false)
    private int reputacion;

    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_registro;

    // @ManyToOne()
    // @JoinColumn(name = "id_cliente")
    // private Cliente cliente;
                                                                                                                                                            
    @OneToMany()
    private List<Producto> producto;

    @OneToOne()
    private Cliente cliente;

    public Cliente_empresa(Integer id_empresa, String dni_ruc, String razon_social, String nombre_comercial, int reputacion, List<Producto> producto, Cliente cliente) {
        this.id_empresa = id_empresa;
        this.dni_ruc = dni_ruc;
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
        this.reputacion = reputacion;
        this.producto = producto;
        this.cliente = cliente;
    }




    
    @Override
    public String toString() {
        return "Ordenes{"
                + "id_empresa=" + id_empresa
                + ", dni_ruc='" + dni_ruc + '\''
                + ", razon_social='" + razon_social + '\''
                + ", nombre_comercial='" + nombre_comercial + '\''
                + ", reputacion=" + reputacion
                + //     ", cliente=" + cliente +
                '}';
    }
}
