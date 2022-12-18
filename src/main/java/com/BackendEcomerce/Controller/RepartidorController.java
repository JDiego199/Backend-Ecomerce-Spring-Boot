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
public class RepartidorController {
      @Autowired
	public RepartidorService RepartidorService;
	
        
        //Guardar
	@PostMapping("/repartidor")
	public Repartidor guardar (@RequestBody Repartidor repartidor){
		
		return RepartidorService.save(repartidor);                       	
	}
	
	//listar
	@GetMapping("/repartidor")
	public List<Repartidor> listar(){
		return RepartidorService.findAll();
	}
	
	@DeleteMapping ("/repartidor/{id}")
	public void eliminar(@PathVariable Integer id){
		RepartidorService.delete(id);
	}
	
        //get una cuenta
	@GetMapping ("/repartidor/{id}")
	public Repartidor getUnaAhorros(@PathVariable Integer id){
		return RepartidorService.findById(id);
	}
	
       /* @PutMapping ("/repartidor/{id}")
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
