/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.Repository.ClienteRepository;
import com.BackendEcomerce.model.Cliente;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mota1
 */

@Service
@RequiredArgsConstructor
public class ClienteServiceImplement implements ClienteService {

   @Autowired
   private ClienteRepository clienteRepository;

   /*    @Override
   public List<Cliente> getAll() {
      List<Cliente> cliente = this.clienteRepository.findAll();

       return cliente;
   }
    @Override
   public Cliente getById(int id) {
       return clienteRepository.getById(id);
   }
   */
   @Override
   @Transactional(readOnly = true)
   public List<Cliente> findAll() {
      return (List<Cliente>) clienteRepository.findAll();

   }

   @Override
   @Transactional(readOnly = false)
   public Cliente save(Cliente cliente) {

      return clienteRepository.save(cliente);
   }

   @Override
   @Transactional(readOnly = true)
   public Cliente findById(Integer id) {
      return clienteRepository.findById(id).orElse(null);
   }

   @Override
   @Transactional(readOnly = false)
   public void delete(Integer id) {
      clienteRepository.deleteById(id);
   }

   @Override
   public Optional<Cliente> getByUserName(String userName) {
      return clienteRepository.findByUserName(userName);
   }

}
