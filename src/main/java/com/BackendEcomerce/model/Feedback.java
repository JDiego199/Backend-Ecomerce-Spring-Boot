/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import javax.persistence.*;
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
@Table (name = "Feedback")
public class Feedback {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_feedback;

    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;



    @ManyToOne()
    private Producto producto;
    
    @ManyToOne()
    private Cliente_persona cliente_persona;
    
    
}

