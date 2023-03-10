/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Cliente;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mota1
 */
public interface ClienteService {

         public List<Cliente> findAll();
    public Cliente save(Cliente cliente);
    public Cliente findById(Integer id);
        public void delete(Integer id);
    // public   Cliente getByUserName(String userName);
      public Optional<Cliente> getByUserName(String userName);
   // void authDeleteByUser(UserDeleteRequest userDeleteRequest);
}
