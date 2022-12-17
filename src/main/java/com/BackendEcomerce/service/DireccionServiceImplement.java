/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.Repository.DireccionRepository;
import com.BackendEcomerce.model.Direccion;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mota1
 */

@Service
@RequiredArgsConstructor
public class DireccionServiceImplement implements DireccionService {
    
     @Autowired
    
   // private ProductoDAO productoDAO;
    //USANDO JPAREPOSITORY
    private DireccionRepository direccionRepository;
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
    @Transactional(readOnly=true)
    public List<Direccion> findAll()
    {
    return (List<Direccion>) direccionRepository.findAll();
    
    }
    
    @Override
       @Transactional(readOnly=false)
    public Direccion save( Direccion direccion){
    
        return direccionRepository.save(direccion);
    }
    
    @Override
       @Transactional(readOnly=true)
    public Direccion findById(Integer id)
    {
        return direccionRepository.findById(id).orElse(null);
    }
    
    @Override
       @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        direccionRepository.deleteById(id);
    }
}
