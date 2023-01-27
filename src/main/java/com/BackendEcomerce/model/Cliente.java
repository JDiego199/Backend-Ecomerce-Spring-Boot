/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;


import com.BackendEcomerce.security.entity.Rol;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

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

   @Column(name = "nombre", nullable = true)
   private String nombre;

   @Column(name = "email", nullable = true)
   private String email;

   @Column(name = "telefono", nullable = true)
   private String telefono;

   @Column(name = "fecha_registro", nullable = true)
   @Temporal(TemporalType.DATE)
   private Calendar fecha_registro;

   @Column(name = "password", nullable = false)
   private String password;

   @Column(name = "userName", nullable = false)
   private String userName;

//   @OneToMany()
//   private List<Feedback> feedback;

   @ManyToMany
   // join columns hace referencia a la columna que hace referencia hacia esta
   // Es decir la tabla usuario_rol va a tener un campo que se llama id_usuario
   // inverseJoinColumns = el inverso, hace referencia a rol
   @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"),
         inverseJoinColumns = @JoinColumn(name = "rol_id"))
   private Set<Rol> roles = new HashSet<>();

   @OneToMany()
   private List<Direccion> direccion;

   @OneToMany()
   private List<Ordenes> ordenes;

   @OneToMany()
   private List<Orden_detalles> ordenDetalles;

   public Cliente(Integer id_cliente, String nombre, String email, String telefono, Calendar fecha_registro, String password, String userName, Set<Rol> roles, List<Direccion> direccion, List<Ordenes> ordenes, List<Orden_detalles> ordenDetalles) {
      this.id_cliente = id_cliente;
      this.nombre = nombre;
      this.email = email;
      this.telefono = telefono;
      this.fecha_registro = fecha_registro;
      this.password = password;
      this.userName = userName;
//      this.feedback = feedback;
      this.roles = roles;
      this.direccion = direccion;
      this.ordenes = ordenes;
      this.ordenDetalles = ordenDetalles;
   }

   @Override
   public String toString() {
      return "Cliente{" +
              "id_cliente=" + id_cliente +
              ", nombre='" + nombre + '\'' +
              ", email='" + email + '\'' +
              ", telefono='" + telefono + '\'' +
              ", fecha_registro=" + fecha_registro +
              ", password='" + password + '\'' +
              ", userName='" + userName + '\'' +
//              ", feedback=" + feedback +
              ", roles=" + roles +
              ", direccion=" + direccion +
              ", ordenDetalles=" + ordenDetalles +
              '}';
   }

}
