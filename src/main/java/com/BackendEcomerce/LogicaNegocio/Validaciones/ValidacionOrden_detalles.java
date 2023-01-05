/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.LogicaNegocio.Validaciones;

import com.BackendEcomerce.model.Producto;
import com.BackendEcomerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mota1
 */

@Service
public class ValidacionOrden_detalles  {
    
    
  @Autowired
  public ProductoService productoservicie;
       
      public boolean validarCantidad(int cantidad) {
       
      Producto prod = new Producto();
      prod =  productoservicie.findById(cantidad);
      
       return prod.getCantidad() >= cantidad;
      
      
   }

}
