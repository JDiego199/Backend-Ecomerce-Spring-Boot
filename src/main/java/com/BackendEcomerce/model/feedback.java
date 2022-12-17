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
 * @author craxz
 */


 @PersistenceContext
 @Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "feeback")
public class feedback {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
        @Column(name = "id_producto", nullable = false)
    private int id_producto;
    
        @Column(name = "id_persona", nullable = false)
    private int id_persona;
    
    
    public feedback(Integer id_producto, Integer id_persona,String descripcion){
        this.id_producto = id_producto;
        this.id_persona = id_persona;
        this.descripcion = descripcion;
    }
    
    
}
