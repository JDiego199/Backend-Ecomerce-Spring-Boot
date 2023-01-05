/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Ordenes;

import java.util.List;

/**
 * @author mota1
 */
public interface OrdenesService {
   public List<Ordenes> findAll();

   public Ordenes save(Ordenes ordenes);

   public Ordenes findById(Integer id);

   public void delete(Integer id);
}
