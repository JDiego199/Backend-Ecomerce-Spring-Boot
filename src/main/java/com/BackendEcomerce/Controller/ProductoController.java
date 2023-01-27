/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.Controller;

import com.BackendEcomerce.model.Cliente;
import com.BackendEcomerce.model.Cliente_empresa;
import com.BackendEcomerce.model.Producto;
import com.BackendEcomerce.service.ClienteService;
import com.BackendEcomerce.service.Cliente_empresaService;
import com.BackendEcomerce.service.ProductoService;
import com.BackendEcomerce.service.ProductoServiceImplement;

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
@CrossOrigin
@RequestMapping("/api/")

public class ProductoController {

   @Autowired
   public ProductoService productoService;
   @Autowired
   public Cliente_empresaService cliente_empresaService;

   @Autowired
   public ProductoServiceImplement productoServiceImplement;

   //Guardar
   @PostMapping("/producto/{id}")
   public Producto guardar(@RequestBody Producto producto, @PathVariable Integer id) {

      Cliente_empresa cliente_empresa = new Cliente_empresa();

      cliente_empresa = cliente_empresaService.findById(id);

      producto.setCliente_empresa(cliente_empresa);
      return productoService.save(producto);
   }

   //listar
   @GetMapping("/producto")
   public List<Producto> listar() {
      return productoService.findAll();
   }

   @GetMapping("/productoEmpresa/{id}")
   public List<Producto> listarPorEmpresa(@PathVariable Integer id) {


      return productoService.findAllEmpresa(id);
   }

   @DeleteMapping("/producto/{id}")
   public void eliminar(@PathVariable Integer id) {
      productoService.delete(id);
   }

   //get una cuenta
   @GetMapping("/producto/{id}")
   public Producto getUnaAhorros(@PathVariable Integer id) {
      return productoService.findById(id);
   }

   @PutMapping("/producto/{id}")
   public Producto modificar(@RequestBody Producto producto, @PathVariable Integer id) {

      Producto productoActual = productoService.findById(id);
      productoActual.setCantidad(producto.getCantidad());
      productoActual.setDescripcion(producto.getDescripcion());
      productoActual.setDescuento(producto.getDescuento());
      productoActual.setPrecio(producto.getPrecio());
      productoActual.setNombre(producto.getNombre());
      productoActual.setPrecio_fabrica(producto.getPrecio_fabrica());
      productoActual.setFecha_registro(producto.getFecha_registro());

      return productoService.save(productoActual);
   }

}
