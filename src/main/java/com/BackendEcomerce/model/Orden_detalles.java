/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import javax.persistence.*;

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
@Table(name = "ordendes_detalles")
public class Orden_detalles {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id_orden_detalle;

   @Column(name = "cantidad", nullable = false)
   private int cantidad;

   @Column(name = "precio", nullable = false)
   private float precio;

//   @Column(name = "fecha_orden", nullable = false)
//   @Temporal(TemporalType.DATE)
//   private Calendar fecha_orden;

   @OneToMany()
   private List<Ordenes> Ordenes;

   @ManyToOne()
   private Producto producto;

   @ManyToOne()
   private  Cliente_empresa cliente_empresa;

   @ManyToOne()
   private  Cliente_persona cliente_persona;

   @Override
   public String toString() {
      return "Orden_detalles{" +
            "id_orden_detalle=" + id_orden_detalle +
            ", cantidad=" + cantidad +
            ", precio=" + precio+
//            ", fecha_orden=" + fecha_orden +
            ", Ordenes=" + Ordenes +
            ", producto=" + producto +
            ", cliente_empresa=" + cliente_empresa +
            ", cliente_persona=" + cliente_persona +
            '}';
   }

   public Orden_detalles(Integer id_orden_detalle, int cantidad, float precio,List<com.BackendEcomerce.model.Ordenes> ordenes, Producto producto, Cliente_empresa cliente_empresa, Cliente_persona cliente_persona) {
      this.id_orden_detalle = id_orden_detalle;
      this.cantidad = cantidad;
      this.precio = precio;
//      this.fecha_orden = fecha_orden;
      Ordenes = ordenes;
      this.producto = producto;
      this.cliente_empresa = cliente_empresa;
      this.cliente_persona = cliente_persona;
   }
}
