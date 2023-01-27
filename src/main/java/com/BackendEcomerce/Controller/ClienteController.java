/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.model.Cliente;
import com.BackendEcomerce.security.entity.Rol;
import com.BackendEcomerce.security.enums.RolNombre;
import com.BackendEcomerce.security.service.RolService;
import com.BackendEcomerce.service.ClienteService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequiredArgsConstructor
public class ClienteController {

   @Autowired
   public ClienteService clienteService;
   @Autowired
   RolService rolService;

 /*   @GetMapping("/cliente")
    public List<Cliente> getAll() {
        List<Cliente> cliente = this.clienteService.getAll();
        return cliente;
    }

    @GetMapping("/cliente/{id}")
    public Cliente getById(@PathVariable int id) {
        return clienteService.getById(id);
    }*/

   //Guardar
   @PostMapping("/cliente")
   public Cliente guardar(@RequestBody Cliente cliente) {

      return clienteService.save(cliente);
   }

   @PutMapping("/clienteCambiarRol/{id}")
   public Cliente CambiarRol(@RequestBody Cliente cliente2, @PathVariable Integer id) {
      Cliente cliente = new Cliente();
      cliente = clienteService.findById(id);
      Set<Rol> roles = new HashSet<>();
      roles.add(rolService.getByRolNombre(RolNombre.ROLE_EMPRESA).get());
      cliente.setRoles(roles);

      return clienteService.save(cliente);
   }

   //listar

   @GetMapping("/cliente")
   public List<Cliente> listar() {
      return clienteService.findAll();
   }

   @GetMapping("/clienteId/{id}")
   public Cliente getById(@PathVariable Integer id) {
      return clienteService.findById(id);
   }


   @DeleteMapping("/cliente/{id}")
   public void eliminar(@PathVariable Integer id) {
      clienteService.delete(id);
   }

   //get una cuenta
   @GetMapping("/cliente/{id}")
   public Optional<Cliente> getUnaAhorros(@PathVariable String id) {
      return clienteService.getByUserName(id);
   }

   @PutMapping("/cliente/{id}")
   public Cliente modificar(@RequestBody Cliente cliente, @PathVariable Integer id) {

      Cliente clientetoActual = clienteService.findById(id);
      clientetoActual.setDireccion(cliente.getDireccion());
      clientetoActual.setPassword(cliente.getPassword());
      clientetoActual.setEmail(cliente.getEmail());
//      clientetoActual.setFecha_nacimient(cliente.getFecha_nacimient());
      clientetoActual.setFecha_registro(cliente.getFecha_registro());
      clientetoActual.setNombre(cliente.getNombre());
      clientetoActual.setUserName(cliente.getUserName());
      clientetoActual.setTelefono(cliente.getTelefono());
      clientetoActual.setRoles(cliente.getRoles());

      return clienteService.save(clientetoActual);
   }
}
