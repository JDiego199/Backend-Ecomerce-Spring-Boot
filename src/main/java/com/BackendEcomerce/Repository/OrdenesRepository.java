/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BackendEcomerce.Repository;

import com.BackendEcomerce.model.Ordenes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mota1
 */
@Repository
public interface OrdenesRepository extends CrudRepository<Ordenes, Integer> {

}
