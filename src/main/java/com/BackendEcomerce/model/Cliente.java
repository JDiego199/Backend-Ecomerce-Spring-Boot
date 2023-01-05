/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;



import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author fabricio
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "cliente")
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

    @Column(name = "fecha_nacimient", nullable = true)
    @Temporal(TemporalType.DATE)
	private Calendar fecha_nacimient;   
    
    @Column(name = "fecha_registro", nullable = true)
    @Temporal(TemporalType.DATE)
	private Calendar fecha_registro;     
    
    @Column(name = "password", nullable = false)
	private String password;
    
     @Column(name = "userName", nullable = false)
	private String userName;
    
     
  //  @OneToOne()
  //  private Cliente_empresa cliente_empresa;
    
    //@OneToOne()
   // private Cliente_persona cliente_persona;
     
    
    @OneToMany()
    private List<Direccion> direccion;


    public Cliente(String nombre, String email, String telefono, Calendar fecha_nacimient, Calendar fecha_registro, String password, String userName, List<Direccion> direccion) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fecha_nacimient = fecha_nacimient;
        this.fecha_registro = fecha_registro;
        this.password = password;
        this.userName = userName;
        this.direccion = direccion;
    }
    
     
    
}
