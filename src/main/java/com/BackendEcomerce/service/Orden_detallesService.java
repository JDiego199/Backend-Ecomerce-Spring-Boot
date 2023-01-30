/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Orden_detalles;

import java.util.List;

/**
 * @author mota1
 */
public interface Orden_detallesService {
   public List<Orden_detalles> findAll();

   public Orden_detalles save(Orden_detalles orden_detalles);

   public Orden_detalles findById(Integer id);

   public void delete(Integer id);
    public List<Orden_detalles> findAllOrdenesDetalles(Integer id);
}
