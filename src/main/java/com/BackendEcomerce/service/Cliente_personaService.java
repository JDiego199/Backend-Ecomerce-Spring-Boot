/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Cliente_persona;

import java.util.List;

/**
 * @author mota1
 */
public interface Cliente_personaService {

   public List<Cliente_persona> findAll();

   public Cliente_persona save(Cliente_persona cliente_persona);

   public Cliente_persona findById(Integer id);

   public void delete(Integer id);
}
