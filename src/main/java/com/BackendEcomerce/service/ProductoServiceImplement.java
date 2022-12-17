/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.DAO.ProductoDAO;
import com.BackendEcomerce.model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mota1
 */

@Service
public class ProductoServiceImplement implements ProductoService {
    @Autowired
    
    private ProductoDAO productoDAO;
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> findAll()
    {
    return (List<Producto>) productoDAO.findAll();
    
    }
    
    @Override
       @Transactional(readOnly=false)
    public Producto save( Producto producto){
    
        return productoDAO.save(producto);
    }
    
    @Override
       @Transactional(readOnly=true)
    public Producto findById(Integer id)
    {
        return productoDAO.findById(id).orElse(null);
    }
    
    @Override
       @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        productoDAO.deleteById(id);
    }
}
