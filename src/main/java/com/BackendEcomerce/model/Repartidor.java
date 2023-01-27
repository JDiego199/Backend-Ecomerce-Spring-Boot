/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import javax.persistence.*;

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

    @OneToMany()
    private List<Ordenes> Ordenes;

    @Override
    public String toString() {
        return "Repartidor{" +
                "id_repartidor=" + id_repartidor +
                ", Nombre_Compania='" + Nombre_Compania + '\'' +
                ", telefono='" + telefono + '\'' +
                ", Ordenes=" + Ordenes +
                '}';
    }

    public Repartidor(Integer id_repartidor, String nombre_Compania, String telefono, List<com.BackendEcomerce.model.Ordenes> ordenes) {
        this.id_repartidor = id_repartidor;
        Nombre_Compania = nombre_Compania;
        this.telefono = telefono;
        Ordenes = ordenes;
    }
}
