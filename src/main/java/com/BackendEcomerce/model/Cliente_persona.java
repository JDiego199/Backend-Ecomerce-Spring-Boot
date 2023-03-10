/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import javax.persistence.*;

import java.util.Calendar;
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
@Table(name = "cliente_persona")
public class Cliente_persona {

    @Id
    @Column(name = "cliente_id")
    private Integer id_persona;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "reputacion", nullable = false)
    private int reputacion;

    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_registro;

    @OneToMany()
    private List<Feedback> feedback;

    @OneToMany()
    private List<Ordenes> ordenes;

    @OneToOne()
    private Cliente cliente;

    public Cliente_persona(Integer id_persona, String dni, int reputacion, Calendar fecha_registro, Cliente cliente, List<com.BackendEcomerce.model.Feedback> feedback, List<Ordenes> orden) {
        this.id_persona = id_persona;
        this.dni = dni;
        this.reputacion = reputacion;
        this.fecha_registro = fecha_registro;
        this.cliente = cliente;
        this.feedback = feedback;
        this.ordenes = ordenes;
    }

    @Override
    public String toString() {
        return "Cliente_persona{"
                + "id_persona=" + id_persona
                + ", dni='" + dni + '\''
                + ", reputacion=" + reputacion
                + ", fecha_registro=" + fecha_registro
                + ", cliente=" + cliente
                + ", feedback=" + feedback
                + ", ordenes=" + ordenes
                + '}';
    }
}
