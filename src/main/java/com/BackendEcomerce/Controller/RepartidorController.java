/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.model.Cliente_empresa;
import com.BackendEcomerce.model.Repartidor;
import com.BackendEcomerce.service.Cliente_empresaService;
import com.BackendEcomerce.service.RepartidorService;

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
public class RepartidorController {
   @Autowired
   public RepartidorService RepartidorService;

   //Guardar
   @PostMapping("/repartidor")
   public Repartidor guardar(@RequestBody Repartidor repartidor) {

      return RepartidorService.save(repartidor);
   }

   //listar
   @GetMapping("/repartidor")
   public List<Repartidor> listar() {
      return RepartidorService.findAll();
   }

   @DeleteMapping("/repartidor/{id}")
   public void eliminar(@PathVariable Integer id) {
      RepartidorService.delete(id);
   }

   //get una cuenta
   @GetMapping("/repartidor/{id}")
   public Repartidor getUnaAhorros(@PathVariable Integer id) {
      return RepartidorService.findById(id);
   }

   @PutMapping("/repartidor/{id}")
   public Repartidor modificar(@RequestBody Repartidor repartidor, @PathVariable Integer id) {

      Repartidor Actual = RepartidorService.findById(id);
      Actual.setNombre_Compania(repartidor.getNombre_Compania());
      Actual.setTelefono(repartidor.getTelefono());


      return RepartidorService.save(Actual);
   }
}
