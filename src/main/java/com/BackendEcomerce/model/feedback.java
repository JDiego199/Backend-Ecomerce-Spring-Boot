/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *
 * @author craxz
 */



@PersistenceContext
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "feedback")
public class feedback {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    private Integer id_persona;
    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @ManyToOne()
    @JoinColumn(name = "producto_id")
    private Producto producto;
    
    

    
    
}
