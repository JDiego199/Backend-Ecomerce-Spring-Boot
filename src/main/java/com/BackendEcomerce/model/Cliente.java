/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author fabricio
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id_cliente;

   @Column(name = "nombre", nullable = false)
   private String nombre;
   @Column(name = "email", nullable = false)
   private String email;
   @Column(name = "telefono", nullable = false)
   private String telefono;

   @Column(name = "fecha_nacimient", nullable = false)
   @Temporal(TemporalType.DATE)
   private Calendar fecha_nacimient;

   @Column(name = "fecha_registro", nullable = false)
   @Temporal(TemporalType.DATE)
   private Calendar fecha_registro;

   @Column(name = "contrasena", nullable = false)
   private String contrasena;

   @Column(name = "nombre_usuario", nullable = false)
   private String nombre_usuario;

   @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
   private Cliente_empresa cliente_empresa;

   @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
   private Cliente_persona cliente_persona;

   @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
   private List<Direccion> direccion;

   public Cliente(String nombre, String email, String telefono, Calendar fecha_nacimient, Calendar fecha_registro, String contrasena, String nombre_usuario, List<Direccion> direccion) {
      this.nombre = nombre;
      this.email = email;
      this.telefono = telefono;
      this.fecha_nacimient = fecha_nacimient;
      this.fecha_registro = fecha_registro;
      this.contrasena = contrasena;
      this.nombre_usuario = nombre_usuario;
      this.direccion = direccion;
   }

}
