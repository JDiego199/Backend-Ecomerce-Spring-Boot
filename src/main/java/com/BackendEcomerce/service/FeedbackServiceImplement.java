/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.Repository.ClienteRepository;
import com.BackendEcomerce.Repository.Cliente_empresaRepository;
import com.BackendEcomerce.model.Cliente_empresa;
import com.BackendEcomerce.Repository.FeedbackRepository;
import com.BackendEcomerce.model.Cliente;
import com.BackendEcomerce.model.Feedback;
import com.BackendEcomerce.model.Producto;
import com.BackendEcomerce.Repository.Cliente_personaRepository;
import com.BackendEcomerce.Repository.OrdenesRepository;
import com.BackendEcomerce.model.Ordenes;

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
public class FeedbackServiceImplement implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private OrdenesRepository ordenesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> findAll() {
        return (List<Feedback>) feedbackRepository.findAll();

    }

    @Override
    @Transactional(readOnly = false)
    public Feedback save(Feedback feedback) {
        
        return feedbackRepository.save(feedback);
    }

    @Override
    @Transactional(readOnly = true)
    public Feedback findById(Integer id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public boolean PermisoComentarFeedback(Integer id, Integer idEmpresa, Feedback feedback) {
        Iterable<Ordenes> orders = ordenesRepository.findAll();
        for (Ordenes order : orders) {
            if ((order.getCliente_persona().getId_persona().equals(id)) && (order.getOrdenes_detalles().getProducto().getCliente_empresa().getId_empresa().equals(idEmpresa))) {              
                  feedbackRepository.save(feedback);
                  return true;
            }
        }
        return false;
    }

}
