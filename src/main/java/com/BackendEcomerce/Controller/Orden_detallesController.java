/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.DAO.ValidacionOrden;
import com.BackendEcomerce.LogicaNegocio.Validaciones.ValidacionOrden_detalles;
import com.BackendEcomerce.model.Orden_detalles;
import com.BackendEcomerce.model.Producto;
import com.BackendEcomerce.service.Orden_detallesService;
import com.BackendEcomerce.service.ProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mota1
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class Orden_detallesController {
   @Autowired
   public Orden_detallesService Orden_detallesService;

   
 public ValidacionOrden vali = new ValidacionOrden();
   //Guardar
   @PostMapping("/orden_detalles")
     public String guardar(@RequestBody Orden_detalles orden_detalles) {
         
         if(vali.validarCantidad(1)){
                 Orden_detallesService.save(orden_detalles);
          return "orden creada";
      }else{return "articulo no existe";}
       
      }
   
  /* public String guardar(@RequestBody Orden_detalles orden_detalles) {
       
      Producto prod = new Producto();
      prod =  productoservicie.findById(orden_detalles.getProducto().getId_producto());
      
      if(prod.getCantidad() >= orden_detalles.getCantidad()){
          Orden_detallesService.save(orden_detalles);
          return "orden creada";
      }else{return "articulo no existe";}
      
      
   }*/

   //listar
   @GetMapping("/orden_detalles")
   public List<Orden_detalles> listar() {
      return Orden_detallesService.findAll();
   }

   @DeleteMapping("/orden_detalles/{id}")
   public void eliminar(@PathVariable Integer id) {
      Orden_detallesService.delete(id);
   }

   //get una cuenta
   @GetMapping("/orden_detalles/{id}")
   public Orden_detalles getUnaAhorros(@PathVariable Integer id) {
      return Orden_detallesService.findById(id);
   }

   @PutMapping("/orden_detalles/{id}")
   public Orden_detalles modificar(@RequestBody Orden_detalles orden_detalles, @PathVariable Integer id) {

      Orden_detalles Actual = Orden_detallesService.findById(id);
      Actual.setCantidad(orden_detalles.getCantidad());
      Actual.setDescuento(orden_detalles.getDescuento());
      Actual.setFecha_orden(orden_detalles.getFecha_orden());
      Actual.setSubtotal(orden_detalles.getSubtotal());

      return Orden_detallesService.save(Actual);
   }
}
