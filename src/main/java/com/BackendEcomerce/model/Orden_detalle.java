/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Calendar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mota1
 */
 @PersistenceContext
    @Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "orden_detalle")
public class Orden_detalle {

    public Orden_detalle(Integer id_orden_detalle, String cantidad, float descuento, float subtotal, Calendar fecha_orden) {
        this.id_orden_detalle = id_orden_detalle;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.subtotal = subtotal;
        this.fecha_orden = fecha_orden;
    }

        
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_orden_detalle;
	
    @Column(name = "cantidad", nullable = false)
	private String cantidad;
    @Column(name = "descuento", nullable = false)
	private float descuento;
    @Column(name = "subtotal", nullable = false)
	private float subtotal;

    @Column(name = "fecha_orden", nullable = false)
    @Temporal(TemporalType.DATE)
	private Calendar fecha_orden;
   
  @ManyToOne
  @JoinColumn(name = "id_orden")
    private Orden orden;

}
