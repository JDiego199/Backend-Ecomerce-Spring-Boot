/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.Repository.FeedbackRepository;
import com.BackendEcomerce.model.Feedback;
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
public class FeedbackServiceImplement implements FeedbackService {
    
      @Autowired
       private FeedbackRepository feedbackRepository;
    
        
    @Override
    @Transactional(readOnly=true)
    public List<Feedback> findAll()
    {
    return (List<Feedback>) feedbackRepository.findAll();
    
    }
    
    @Override
       @Transactional(readOnly=false)
    public Feedback save( Feedback feedback){
    
        return feedbackRepository.save(feedback);
    }
    
    @Override
       @Transactional(readOnly=true)
    public Feedback findById(Integer id)
    {
        return feedbackRepository.findById(id).orElse(null);
    }
    
    @Override
       @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        feedbackRepository.deleteById(id);
    }
}
