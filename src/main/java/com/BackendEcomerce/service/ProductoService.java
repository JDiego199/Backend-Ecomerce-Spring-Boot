/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Producto;

import java.util.List;

/**
 * @author mota1
 */
public interface ProductoService {
   /*  List<Producto> getAll();
      Producto getById(int id);*/

   public List<Producto> findAll();

   public Producto save(Producto producto);

   public Producto findById(Integer id);

   public void delete(Integer id);

}
