/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.Repository;

/**
 *
 * @author fabricio
 */
import com.BackendEcomerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface RoleRepository extends JpaRepository<Role, Integer> {
 
}