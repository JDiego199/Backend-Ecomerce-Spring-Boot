/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.model.Direccion;
import com.BackendEcomerce.service.DireccionService;
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

public class DireccionController {
    
        @Autowired
	public DireccionService direccionService;
	
        
        //Guardar
	@PostMapping("/direccion")
	public Direccion guardar (@RequestBody Direccion direccion){
		
		return direccionService.save(direccion);                       	
	}
	
	//listar
	@GetMapping("/direccion")
	public List<Direccion> listar(){
		return direccionService.findAll();
	}
	
	/*@DeleteMapping ("/producto/{id}")
	public void eliminar(@PathVariable Integer id){
		productoService.delete(id);
	}*/
	
        //get una cuenta
	@GetMapping ("/direccion/{id}")
	public Direccion getUnaAhorros(@PathVariable Integer id){
		return direccionService.findById(id);
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
   
                return productoService.save(productoActual);
	}*/
}
