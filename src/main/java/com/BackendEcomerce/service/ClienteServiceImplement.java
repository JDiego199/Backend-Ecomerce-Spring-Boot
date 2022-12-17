/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.Repository.ClienteRepository;
import com.BackendEcomerce.model.Cliente;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mota1
 */
@Service
@RequiredArgsConstructor
public class ClienteServiceImplement implements ClienteService{
    
    @Autowired
       private ClienteRepository clienteRepository;
    
        @Override
    public List<Cliente> getAll() {
       List<Cliente> cliente = this.clienteRepository.findAll();
        
        return cliente;
    }
     @Override
    public Cliente getById(int id) {
        return clienteRepository.getById(id);
    }
    
     
}
