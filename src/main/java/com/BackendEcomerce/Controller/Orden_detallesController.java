/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.model.Orden_detalles;
import com.BackendEcomerce.service.Orden_detallesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class Orden_detallesController {
      @Autowired
	public Orden_detallesService Orden_detallesService;
	
        
        //Guardar
	@PostMapping("/orden_detalles")
	public Orden_detalles guardar (@RequestBody Orden_detalles orden_detalles){
		
		return Orden_detallesService.save(orden_detalles);                       	
	}
	
	//listar
	@GetMapping("/orden_detalles")
	public List<Orden_detalles> listar(){
		return Orden_detallesService.findAll();
	}
	
	@DeleteMapping ("/orden_detalles/{id}")
	public void eliminar(@PathVariable Integer id){
		Orden_detallesService.delete(id);
	}
	
        //get una cuenta
	@GetMapping ("/orden_detalles/{id}")
	public Orden_detalles getUnaAhorros(@PathVariable Integer id){
		return Orden_detallesService.findById(id);
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
