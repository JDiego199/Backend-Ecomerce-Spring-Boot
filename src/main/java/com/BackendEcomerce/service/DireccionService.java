/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Direccion;

import java.util.List;

/**
 * @author mota1
 */
public interface DireccionService {

   public List<Direccion> findAll();

   public Direccion save(Direccion direccion);

   public Direccion findById(Integer id);

   public void delete(Integer id);

}
