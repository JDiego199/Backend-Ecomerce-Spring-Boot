/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.model.Cliente_empresa;
import com.BackendEcomerce.service.Cliente_empresaService;

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
public class Cliente_empersaController {

   @Autowired
   public Cliente_empresaService cliente_empresaService;

   //Guardar
   @PostMapping("/cliente_empresa")
   public Cliente_empresa guardar(@RequestBody Cliente_empresa cliente_empresa) {

      return cliente_empresaService.save(cliente_empresa);
   }

   //listar
   @GetMapping("/cliente_empresa")
   public List<Cliente_empresa> listar() {
      return cliente_empresaService.findAll();
   }

   @DeleteMapping("/cliente_empresa/{id}")
   public void eliminar(@PathVariable Integer id) {
      cliente_empresaService.delete(id);
   }

   //get una cuenta
   @GetMapping("/cliente_empresa/{id}")
   public Cliente_empresa getUnaAhorros(@PathVariable Integer id) {
      return cliente_empresaService.findById(id);
   }

   @PutMapping("/cliente_empresa/{id}")
   public Cliente_empresa modificar(@RequestBody Cliente_empresa cliente_empresa, @PathVariable Integer id) {

      Cliente_empresa Actual = cliente_empresaService.findById(id);
      Actual.setDni_ruc(cliente_empresa.getDni_ruc());
      Actual.setFecha_registro(cliente_empresa.getFecha_registro());
      Actual.setId_empresa(cliente_empresa.getId_empresa());
      Actual.setNombre_comercial(cliente_empresa.getNombre_comercial());
      Actual.setRazon_social(cliente_empresa.getRazon_social());
      Actual.setReputacion(cliente_empresa.getReputacion());

      return cliente_empresaService.save(Actual);
   }

}
