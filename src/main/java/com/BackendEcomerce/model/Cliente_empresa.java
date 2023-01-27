/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import javax.persistence.*;

import java.util.Arrays;
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

   @OneToMany()
   private List<Ordenes> ordenes;

   @OneToMany()
   private List<Orden_detalles> ordenDetalles;

   @Column(name = "imagen")
   private String[] fileList;

   @Override
   public String toString() {
      return "Cliente_empresa{" +
            "id_empresa=" + id_empresa +
            ", dni_ruc='" + dni_ruc + '\'' +
            ", razon_social='" + razon_social + '\'' +
            ", nombre_comercial='" + nombre_comercial + '\'' +
            ", reputacion=" + reputacion +
            ", fecha_registro=" + fecha_registro +
            ", producto=" + producto +
            ", cliente=" + cliente +
            ", ordenes=" + ordenes +
            ", ordenDetalles=" + ordenDetalles +
            ", fileList=" + Arrays.toString(fileList) +
            '}';
   }

   public Cliente_empresa(Integer id_empresa, String dni_ruc, String razon_social, String nombre_comercial, int reputacion, Calendar fecha_registro, List<Producto> producto, Cliente cliente, List<Ordenes> ordenes, List<Orden_detalles> ordenDetalles) {
      this.id_empresa = id_empresa;
      this.dni_ruc = dni_ruc;
      this.razon_social = razon_social;
      this.nombre_comercial = nombre_comercial;
      this.reputacion = reputacion;
      this.fecha_registro = fecha_registro;
      this.producto = producto;
      this.cliente = cliente;
      this.ordenes = ordenes;
      this.ordenDetalles = ordenDetalles;
   }
}
