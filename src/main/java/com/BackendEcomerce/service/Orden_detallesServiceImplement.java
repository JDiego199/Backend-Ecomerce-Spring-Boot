/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.Repository.Orden_detallesRepository;
import com.BackendEcomerce.model.Orden_detalles;
import java.util.ArrayList;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mota1
 */
@Service
@RequiredArgsConstructor
public class Orden_detallesServiceImplement implements Orden_detallesService {

   @Autowired
   private Orden_detallesRepository orden_detallesRepository;

   @Override
   @Transactional(readOnly = true)
   public List<Orden_detalles> findAll() {
      return (List<Orden_detalles>) orden_detallesRepository.findAll();
   }

   @Override
   @Transactional(readOnly = false)
   public Orden_detalles save(Orden_detalles orden_detalles) {
      return orden_detallesRepository.save(orden_detalles);
   }

   @Override
   @Transactional(readOnly = true)
   public Orden_detalles findById(Integer id) {
      return orden_detallesRepository.findById(id).orElse(null);
   }

   @Override
   @Transactional(readOnly = false)
   public void delete(Integer id) {
      orden_detallesRepository.deleteById(id);
   }
   
      @Override
   @Transactional(readOnly = true)
   public List<Orden_detalles> findAllOrdenesDetalles(Integer id) {

      List<Orden_detalles> x;
      List<Orden_detalles> y = new ArrayList<>();
      x = (List<Orden_detalles>) orden_detallesRepository.findAll();
      Integer a;
      int n = x.size();
      for (int i = 0; i < n; i++) {

         a = x.get(i).getCliente().getId_cliente();
         //  System.out.printf("valor a: "+a+" valor id: "+id);
        // System.out.printf(x.get(i).getCliente_empresa().getId_empresa().toString());
         if (a == id) {
            y.add(x.get(i));
         }
      }

      return y;
   }

}
