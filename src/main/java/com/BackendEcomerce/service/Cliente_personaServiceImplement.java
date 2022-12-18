/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.Repository.Cliente_empresaRepository;
import com.BackendEcomerce.Repository.Cliente_personaRepository;
import com.BackendEcomerce.model.Cliente_empresa;
import com.BackendEcomerce.model.Cliente_persona;
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
public class Cliente_personaServiceImplement implements Cliente_personaService {
    
     @Autowired
       private Cliente_personaRepository cliente_personaRepository;
    
        
    @Override
    @Transactional(readOnly=true)
    public List<Cliente_persona> findAll()
    {
    return (List<Cliente_persona>) cliente_personaRepository.findAll();
    
    }
    
    @Override
       @Transactional(readOnly=false)
    public Cliente_persona save( Cliente_persona cliente_persona){
    
        return cliente_personaRepository.save(cliente_persona);
    }
    
    @Override
       @Transactional(readOnly=true)
    public Cliente_persona findById(Integer id)
    {
        return cliente_personaRepository.findById(id).orElse(null);
    }
    
    @Override
       @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        cliente_personaRepository.deleteById(id);
    }
}
