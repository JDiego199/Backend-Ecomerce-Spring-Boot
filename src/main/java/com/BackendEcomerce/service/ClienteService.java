/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Cliente;
import com.BackendEcomerce.model.Producto;
import java.util.List;

/**
 *
 * @author mota1
 */
public interface ClienteService {
         List<Cliente> getAll();
      Cliente getById(int id);
}
