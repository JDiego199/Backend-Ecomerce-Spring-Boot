/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.model.Repartidor;
import java.util.List;

/**
 *
 * @author mota1
 */
public interface RepartidorService {
        public List<Repartidor> findAll();

    public Repartidor save(Repartidor repartidor);

    public Repartidor findById(Integer id);

    public void delete(Integer id);
}
