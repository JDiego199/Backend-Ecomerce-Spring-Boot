/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import jakarta.persistence.*;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mota1
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "repartidor")
public class Repartidor {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id_repartidor;

   @Column(name = "Nombre_Compania", nullable = false)
   private String Nombre_Compania;

   @Column(name = "telefono", nullable = false)
   private String telefono;

   @OneToMany(mappedBy = "repartidor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
   private List<Ordenes> Ordenes;

}
