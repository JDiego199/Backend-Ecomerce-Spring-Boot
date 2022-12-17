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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mota1
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping ("/api/")
public class Cliente_empersaController {
    
        @Autowired
	public Cliente_empresaService cliente_empresaService;
	
        
        //Guardar
	@PostMapping("/cliente_empresa")
	public Cliente_empresa guardar (@RequestBody Cliente_empresa cliente_empresa){
		
		return cliente_empresaService.save(cliente_empresa);                       	
	}
	
	//listar
	@GetMapping("/cliente_empresa")
	public List<Cliente_empresa> listar(){
		return cliente_empresaService.findAll();
	}
	
	/*@DeleteMapping ("/producto/{id}")
	public void eliminar(@PathVariable Integer id){
		productoService.delete(id);
	}*/
	
        //get una cuenta
	@GetMapping ("/cliente_empresa/{id}")
	public Cliente_empresa getUnaAhorros(@PathVariable Integer id){
		return cliente_empresaService.findById(id);
	}
	
       /* @PutMapping ("/producto/{id}")
	public Producto modificar (@RequestBody Producto producto, @PathVariable Integer id){
		
                Producto productoActual = productoService.findById(id);
                productoActual.setCantidad(producto.getCantidad());
                productoActual.setDescripcion(producto.getDescripcion());
                productoActual.setDescuento(producto.getDescuento());
                productoActual.setPrecio(producto.getPrecio());
                productoActual.setNombre(producto.getNombre());
                productoActual.setPrecio_fabrica(producto.getPrecio_fabrica());
                productoActual.setFecha_registro(producto.getFecha_registro());
   
                return cliente_empresaService.save(productoActual);
	}*/
    
}
