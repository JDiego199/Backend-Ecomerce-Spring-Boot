/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.DAO.ProductoDAO;
import com.BackendEcomerce.Repository.ProductoRepository;
import com.BackendEcomerce.model.Producto;

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
public class ProductoServiceImplement implements ProductoService {
   @Autowired
   // private ProductoDAO productoDAO;
   //USANDO JPAREPOSITORY
   private ProductoRepository productoRepository;
    /*
        @Override
    public List<Producto> getAll() {
        return this.productoRepository.findAll();
    }
    
       @Override
    public Producto getById(int id) {
        Producto producto = productoRepository.findById(id).orElseThrow();
        return producto;
    }*/


   @Override
   @Transactional(readOnly = true)
   public List<Producto> findAll() {
      return (List<Producto>) productoRepository.findAll();
   }

   @Override
   @Transactional(readOnly = false)
   public Producto save(Producto producto) {
      return productoRepository.save(producto);
   }

   @Override
   @Transactional(readOnly = true)
   public Producto findById(Integer id) {
      return productoRepository.findById(id).orElse(null);
   }

   @Override
   @Transactional(readOnly = false)
   public void delete(Integer id) {
      productoRepository.deleteById(id);
   }
}
