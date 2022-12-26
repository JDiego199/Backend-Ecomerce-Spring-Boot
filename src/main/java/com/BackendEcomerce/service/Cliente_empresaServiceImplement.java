/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Cliente_empresa;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.BackendEcomerce.Repository.Cliente_empresaRepository;

/**
 * @author mota1
 */
@Service
@RequiredArgsConstructor
public class Cliente_empresaServiceImplement implements Cliente_empresaService {


   @Autowired
   private Cliente_empresaRepository cliente_empresaRepository;


   @Override
   @Transactional(readOnly = true)
   public List<Cliente_empresa> findAll() {
      return (List<Cliente_empresa>) cliente_empresaRepository.findAll();
   }

   @Override
   @Transactional(readOnly = false)
   public Cliente_empresa save(Cliente_empresa cliente_empresa) {
      return cliente_empresaRepository.save(cliente_empresa);
   }

   @Override
   @Transactional(readOnly = true)
   public Cliente_empresa findById(Integer id) {
      return cliente_empresaRepository.findById(id).orElse(null);
   }

   @Override
   @Transactional(readOnly = false)
   public void delete(Integer id) {
      cliente_empresaRepository.deleteById(id);
   }
}
