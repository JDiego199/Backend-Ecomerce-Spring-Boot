/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.model.Cliente;
import com.BackendEcomerce.service.ClienteService;
import com.BackendEcomerce.service.ProductoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
 *
 * @author mota1
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ClienteController {
        @Autowired
    public ClienteService clienteService;

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
	public Cliente guardar (@RequestBody Cliente cliente){
		
		return clienteService.save(cliente);                       	
	}
	
	//listar
	@GetMapping("/cliente")
	public List<Cliente> listar(){
		return clienteService.findAll();
	}
	
	@DeleteMapping ("/cliente/{id}")
	public void eliminar(@PathVariable Integer id){
		clienteService.delete(id);
	}
	
        //get una cuenta
	@GetMapping ("/cliente/{id}")
	public Cliente getUnaAhorros(@PathVariable Integer id){
		return clienteService.findById(id);
	}
	
        @PutMapping ("/cliente/{id}")
	public Cliente modificar (@RequestBody Cliente cliente, @PathVariable Integer id){
		
                Cliente clientetoActual = clienteService.findById(id);
                clientetoActual.setDireccion(cliente.getDireccion());
                clientetoActual.setContrasena(cliente.getContrasena());
                clientetoActual.setEmail(cliente.getEmail());
                clientetoActual.setFecha_nacimient(cliente.getFecha_nacimient());
                clientetoActual.setFecha_registro(cliente.getFecha_registro());
                clientetoActual.setNombre(cliente.getNombre());
                clientetoActual.setNombre_usuario(cliente.getNombre_usuario());
                clientetoActual.setTelefono(cliente.getTelefono());
   
                return clienteService.save(clientetoActual);
	}
}
