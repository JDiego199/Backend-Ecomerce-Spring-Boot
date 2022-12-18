/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.Repository.OrdenesRepository;
import com.BackendEcomerce.model.Ordenes;
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
public class OrdenesServiceImplement implements OrdenesService {
    
      @Autowired
       private OrdenesRepository ordenesRepository;
    
        
    @Override
    @Transactional(readOnly=true)
    public List<Ordenes> findAll()
    {
    return (List<Ordenes>) ordenesRepository.findAll();
    
    }
    
    @Override
       @Transactional(readOnly=false)
    public Ordenes save( Ordenes ordenes){
    
        return ordenesRepository.save(ordenes);
    }
    
    @Override
       @Transactional(readOnly=true)
    public Ordenes findById(Integer id)
    {
        return ordenesRepository.findById(id).orElse(null);
    }
    
    @Override
       @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        ordenesRepository.deleteById(id);
    }
    
}
