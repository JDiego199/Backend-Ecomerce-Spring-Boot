/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;


import com.BackendEcomerce.model.Ordenes;
import com.BackendEcomerce.service.OrdenesService;
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
public class OrdenesController {
      @Autowired
	public OrdenesService OrdenesService;
	
        
        //Guardar
	@PostMapping("/ordenes")
	public Ordenes guardar (@RequestBody Ordenes ordenes){
		
		return OrdenesService.save(ordenes);                       	
	}
	
	//listar
	@GetMapping("/ordenes")
	public List<Ordenes> listar(){
		return OrdenesService.findAll();
	}
	
	@DeleteMapping ("/ordenes/{id}")
	public void eliminar(@PathVariable Integer id){
		OrdenesService.delete(id);
	}
	
        //get una cuenta
	@GetMapping ("/ordenes/{id}")
	public Ordenes getUnaAhorros(@PathVariable Integer id){
		return OrdenesService.findById(id);
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
