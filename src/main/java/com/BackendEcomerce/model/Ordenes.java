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
 *
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

    @Column(name = "numero_factura", nullable = false)
    private int numero_factura;
    @Column(name = "subTotal", nullable = false)
    private float subTotal;
    @Column(name = "total", nullable = false)
    private float total;
    @Column(name = "iva", nullable = false)
    private float iva;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha;

    @OneToMany()
    private List<Orden_detalles> orden_detalles;

    @ManyToOne()
    private Repartidor repartidor;

    @ManyToOne()
    private Cliente_persona cliente_persona;

}
