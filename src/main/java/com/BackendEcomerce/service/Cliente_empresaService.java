/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Cliente_empresa;
import java.util.List;

/**
 *
 * @author mota1
 */
public interface Cliente_empresaService {
    public List<Cliente_empresa> findAll();
    public Cliente_empresa save(Cliente_empresa cliente_empresa);
    public Cliente_empresa findById(Integer id);
        public void delete(Integer id);
      
}
