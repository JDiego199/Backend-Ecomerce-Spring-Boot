/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import javax.persistence.*;

import java.util.Calendar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
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
    @Column(name = "descuento", nullable = false)
    private float descuento;
    @Column(name = "subtotal", nullable = false)
    private float subtotal;

    @Column(name = "fecha_orden", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_orden;

    @ManyToOne()
    private Ordenes ordenes;

    @ManyToOne()
    private Producto producto;

}
