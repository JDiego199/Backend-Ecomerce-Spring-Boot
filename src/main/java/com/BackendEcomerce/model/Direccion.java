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
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author fabricio
 */
@PersistenceContext
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "direccion")
public class Direccion{
    
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_direccion;
	
    @Column(name = "direccion", nullable = false)
	private String direccion;
    @Column(name = "ciudad", nullable = false)
	private String ciudad;
    @Column(name = "provincia", nullable = false)
	private String provincia;

    @Column(name = "calle", nullable = false)
    @Temporal(TemporalType.DATE)
	private String calle;
    
     @Column(name = "codigo_postal", nullable = false)
       private String codigo_postal;
    
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
	private Calendar fecha;   
    
    
    
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
}