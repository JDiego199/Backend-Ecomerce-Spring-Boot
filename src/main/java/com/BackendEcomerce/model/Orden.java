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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Calendar;
import java.util.List;
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
@Table (name = "orden")
public class Orden {
    
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
    
    
    
 
    @OneToMany(mappedBy = "orden_detalle")
   private List<Orden_detalle> orden_detalle;

    public Orden(Integer id_orden, int numero_factura, float subTotal, float total, float iva, Calendar fecha) {
        this.id_orden = id_orden;
        this.numero_factura = numero_factura;
        this.subTotal = subTotal;
        this.total = total;
        this.iva = iva;
        this.fecha = fecha;
    }
}
