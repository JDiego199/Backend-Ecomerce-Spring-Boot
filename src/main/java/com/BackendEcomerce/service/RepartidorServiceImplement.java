/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.Repository.RepartidorRepository;
import com.BackendEcomerce.model.Repartidor;
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
public class RepartidorServiceImplement implements RepartidorService {
    
      @Autowired
       private RepartidorRepository repartidorRepository;
    
        
    @Override
    @Transactional(readOnly=true)
    public List<Repartidor> findAll()
    {
    return (List<Repartidor>) repartidorRepository.findAll();
    
    }
    
    @Override
       @Transactional(readOnly=false)
    public Repartidor save( Repartidor repartidor){
    
        return repartidorRepository.save(repartidor);
    }
    
    @Override
       @Transactional(readOnly=true)
    public Repartidor findById(Integer id)
    {
        return repartidorRepository.findById(id).orElse(null);
    }
    
    @Override
       @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        repartidorRepository.deleteById(id);
    }
}
