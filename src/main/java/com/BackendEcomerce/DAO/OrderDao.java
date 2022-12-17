/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.DAO;

import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mota1
 */
public interface OrderDao extends JpaRepository<Order, Integer> {
    
}
