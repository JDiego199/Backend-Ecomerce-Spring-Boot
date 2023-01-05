/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.LogicaNegocio.Validaciones;

import com.BackendEcomerce.model.Producto;
import com.BackendEcomerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author mota1
 */

public class ValidacionOrden_detalles {
    
   @Autowired
   public ProductoService productoservicie;
       
       public boolean validarCantidad(int cantidad) {
       
      Producto prod = new Producto();
      prod =  productoservicie.findById(cantidad);
      
      if(prod.getCantidad() >= cantidad){
         
          return true;
      }else{return false;}
      
      
   }

}
