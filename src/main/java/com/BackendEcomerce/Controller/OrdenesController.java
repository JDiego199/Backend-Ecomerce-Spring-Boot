/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;


import com.BackendEcomerce.model.Orden_detalles;
import com.BackendEcomerce.model.Ordenes;
import com.BackendEcomerce.service.Orden_detallesService;
import com.BackendEcomerce.service.OrdenesService;

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
public class OrdenesController {
   @Autowired
   public OrdenesService OrdenesService;
    @Autowired
   public Orden_detallesService orden_detalles;

   //Guardar
   @PostMapping("/ordenes")
   public Ordenes guardar(@RequestBody Ordenes ordenes) {

        OrdenesService.confirmarOrder(ordenes.getOrdenes_detalles().getProducto().getId_producto(), ordenes.getOrdenes_detalles().getCantidad());
      return OrdenesService.save(ordenes);
      
     //Orden_detalles orden = new Orden_detalles();
      
     
   }

   //listar
   @GetMapping("/ordenes")
   public List<Ordenes> listar() {
      return OrdenesService.findAll();
   }

   @DeleteMapping("/ordenes/{id}")
   public void eliminar(@PathVariable Integer id) {
      OrdenesService.delete(id);
   }

   //get una cuenta
   @GetMapping("/ordenes/{id}")
   public Ordenes getUnaAhorros(@PathVariable Integer id) {
      return OrdenesService.findById(id);
   }

   @PutMapping("/ordenes/{id}")
   public Ordenes modificar(@RequestBody Ordenes ordenes, @PathVariable Integer id) {

      Ordenes Actual = OrdenesService.findById(id);
      Actual.setFecha(ordenes.getFecha());
      Actual.setIva(ordenes.getIva());
      Actual.setNumero_factura(ordenes.getNumero_factura());
      Actual.setSubTotal(ordenes.getSubTotal());
      Actual.setTotal(ordenes.getTotal());

      return OrdenesService.save(Actual);
   }
   
   

}
