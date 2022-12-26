/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Feedback;

import java.util.List;

/**
 * @author mota1
 */
public interface FeedbackService {
   public List<Feedback> findAll();

   public Feedback save(Feedback feedback);

   public Feedback findById(Integer id);

   public void delete(Integer id);
}
