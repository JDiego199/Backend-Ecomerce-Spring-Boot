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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table (name = "cliente")
public class Cliente {
    
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cliente;
	
    @Column(name = "nombre", nullable = false)
	private String nombre;
    @Column(name = "email", nullable = false)
	private String email;
    @Column(name = "telefono", nullable = false)
	private int total;

    @Column(name = "fecha_nacimient", nullable = false)
    @Temporal(TemporalType.DATE)
	private Calendar fecha;   
    
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
	private Calendar fecha2;     
    
    @Column(name = "contrasena", nullable = false)
	private String contrasena;
    
     @Column(name = "nombre_usuario", nullable = false)
	private String nombre_usuario;
    
     
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cliente_empresa cliente_empresa;
    
       @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cliente_persona cliente_persona;
     
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Direccion direccion;
     
}
