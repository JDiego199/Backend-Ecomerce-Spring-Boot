/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

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
    @OneToMany(mappedBy = "cliente_empresa", cascade = CascadeType.ALL)
    private List<Producto> producto;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Cliente_empresa(Integer id_empresa, String dni_ruc, String razon_social, String nombre_comercial, int reputacion, Calendar fecha_registro) {
        this.id_empresa = id_empresa;
        this.dni_ruc = dni_ruc;
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
        this.reputacion = reputacion;
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "Ordenes{"
                + "id_empresa=" + id_empresa
                + ", dni_ruc='" + dni_ruc + '\''
                + ", razon_social='" + razon_social + '\''
                + ", nombre_comercial='" + nombre_comercial + '\''
                + ", reputacion=" + reputacion
                + ", fecha_registro=" + fecha_registro
                + //     ", cliente=" + cliente +
                '}';
    }
}
