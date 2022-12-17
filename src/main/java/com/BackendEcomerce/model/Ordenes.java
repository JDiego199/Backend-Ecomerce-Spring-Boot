/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    
    
    @OneToMany(mappedBy = "ordenes", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orden_detalles> orden_detalles;
    
}
