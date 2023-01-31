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
@Table(name = "ordenes")
public class Ordenes {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id_orden;

   @Column(name = "numero_factura")
   private int numero_factura;
   @Column(name = "subTotal")
   private float subTotal;
   @Column(name = "total")
   private float total;
   @Column(name = "iva")
   private float iva;

   @Column(name = "fecha")
   @Temporal(TemporalType.DATE)
   private Calendar fecha;

   @OneToMany()
   private List<Orden_detalles> Orden_detalles;

   @ManyToOne()
   private Repartidor repartidor;

   @ManyToOne()
   private Cliente cliente;
   
     @ManyToOne()
   private Cliente_empresa cliente_empresa;

}
