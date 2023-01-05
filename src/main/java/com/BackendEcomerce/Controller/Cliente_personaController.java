/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.model.Cliente_persona;
import com.BackendEcomerce.service.Cliente_personaService;

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
public class Cliente_personaController {
   @Autowired
   public Cliente_personaService cliente_personaService;


   //Guardar
   @PostMapping("/cliente_persona")
   public Cliente_persona guardar(@RequestBody Cliente_persona cliente_persona) {

      return cliente_personaService.save(cliente_persona);
   }

   //listar
   @GetMapping("/cliente_persona")
   public List<Cliente_persona> listar() {
      return cliente_personaService.findAll();
   }

   @DeleteMapping("/cliente_persona/{id}")
   public void eliminar(@PathVariable Integer id) {
      cliente_personaService.delete(id);
   }

   //get una cuenta
   @GetMapping("/cliente_persona/{id}")
   public Cliente_persona getUnaAhorros(@PathVariable Integer id) {
      return cliente_personaService.findById(id);
   }

   @PutMapping("/Cliente_persona/{id}")
   public Cliente_persona modificar(@RequestBody Cliente_persona Cliente_persona, @PathVariable Integer id) {

      Cliente_persona Actual = cliente_personaService.findById(id);

      Actual.setDni(Cliente_persona.getDni());
      Actual.setFecha_registro(Cliente_persona.getFecha_registro());
      Actual.setReputacion(Cliente_persona.getReputacion());
      Actual.setId_persona(Cliente_persona.getId_persona());

      return cliente_personaService.save(Actual);
   }
}
