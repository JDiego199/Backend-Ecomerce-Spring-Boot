/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.Repository.Orden_detallesRepository;
import com.BackendEcomerce.Repository.OrdenesRepository;
import com.BackendEcomerce.Repository.ProductoRepository;
import com.BackendEcomerce.model.Orden_detalles;
import com.BackendEcomerce.model.Ordenes;
import com.BackendEcomerce.model.Producto;
import java.util.ArrayList;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mota1
 */
@Service
@RequiredArgsConstructor
public class OrdenesServiceImplement implements OrdenesService {

    @Autowired
    private OrdenesRepository ordenesRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private Orden_detallesRepository orden_detallesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Ordenes> findAll() {
        return (List<Ordenes>) ordenesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Ordenes save(Ordenes ordenes) {
        return ordenesRepository.save(ordenes);
    }

    @Override
    @Transactional(readOnly = true)
    public Ordenes findById(Integer id) {
        return ordenesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        ordenesRepository.deleteById(id);
    }

    public void confirmarOrder(Integer id, Integer idprod) {

        //obtener id del producto y su cantidad
        Producto productoActual = new Producto();
        productoActual = productoRepository.findById(id).orElse(null);

        productoActual.setCantidad(productoActual.getCantidad() - idprod);

        productoRepository.save(productoActual);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Ordenes> findAllOrdenesEmpresa(Integer id) {

        List<Orden_detalles> x;
        List<Ordenes> ord;
        List<Ordenes> y = new ArrayList<>();
        x = (List<Orden_detalles>) orden_detallesRepository.findAll();
        ord = (List<Ordenes>) ordenesRepository.findAll();
        Integer a;
        int n = x.size();
        int n1 = ord.size();
        boolean existe = true;
         boolean existe2 = true;
        for (int i = 0; i < n; i++) {

            a = x.get(i).getProducto().getCliente_empresa().getId_empresa();
            //  System.out.printf("valor a: "+a+" valor id: "+id);
            // System.out.printf(x.get(i).getCliente_empresa().getId_empresa().toString());
            if (a == id) {

                for (int j = 0; j < n1; j++) {

                    if (x.get(i).getOrdenes().getId_orden() == ord.get(j).getId_orden()) {

                                     
                          if(existe2 ==  true){ y.add(ord.get(j));}else{
                          
                              
                          }
                            
                        for (int e = 0; e < y.size(); e++) {
                            if (y.get(e).getId_orden() == x.get(i).getOrdenes().getId_orden()) {
                                existe = false;
                                  existe2 = false;
                                break;
                            }else{
                                 existe = true;
                                  existe2 = false;
                         
                            }
                        }
                            if(existe ==  true){ y.add(ord.get(j));}else{
                          
                              
                          }
                            

                                     
                    }
                    
                }
              
            }
        }

        return y;
    }
    
    
          @Override
   @Transactional(readOnly = true)
   public List<Ordenes> findAllOrdenesCliente(Integer id) {

      List<Ordenes> x;
      List<Ordenes> y = new ArrayList<>();
      x = (List<Ordenes>) ordenesRepository.findAll();
      Integer a;
      int n = x.size();
      for (int i = 0; i < n; i++) {

         a = x.get(i).getCliente().getId_cliente();
         //  System.out.printf("valor a: "+a+" valor id: "+id);
        // System.out.printf(x.get(i).getCliente_empresa().getId_empresa().toString());
         if (a == id ) {
            y.add(x.get(i));
         }
      }

      return y;
   }

}
