/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.security.repository;

import com.BackendEcomerce.security.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mota1
 */
public interface usuario_rol extends JpaRepository<Rol, Integer> {

}
