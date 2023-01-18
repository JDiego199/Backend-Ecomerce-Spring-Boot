/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.service;

import com.BackendEcomerce.DAO.ProductoDAO;
import com.BackendEcomerce.Repository.ProductoRepository;
import com.BackendEcomerce.model.Producto;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mota1
 */
@Service
@RequiredArgsConstructor
public class ProductoServiceImplement implements ProductoService {

    @Autowired
    // private ProductoDAO productoDAO;
    //USANDO JPAREPOSITORY
    private ProductoRepository productoRepository;

    /*
        @Override
    public List<Producto> getAll() {
        return this.productoRepository.findAll();
    }
    
       @Override
    public Producto getById(int id) {
        Producto producto = productoRepository.findById(id).orElseThrow();
        return producto;
    }*/
    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAllEmpresa(Integer id) {

        List<Producto> x;
        List<Producto> y = new ArrayList<>();
        x = (List<Producto>) productoRepository.findAll();
        Integer a;
        int n = x.size();
        for (int i = 0; i < n; i++) {

            a = x.get(i).getCliente_empresa().getId_empresa();
            //  System.out.printf("valor a: "+a+" valor id: "+id);
            System.out.printf(x.get(i).getCliente_empresa().getId_empresa().toString());
            if (a == id) {
                y.add(x.get(i));
            }
        }

        return y;
    }

    @Override
    @Transactional(readOnly = false)
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Integer id) {

        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findByIdMay0(Integer id) {

        if (ControlNumeroProduct(id)) {

            return productoRepository.findById(id).orElse(null);

        } else {
            return (null);
        }

    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public boolean validarStoc(Integer cantidad, Integer id) {

        Producto prod = new Producto();
        prod = productoRepository.findById(id).orElse(null);
        return prod.getCantidad() >= cantidad;
    }

    @Override
    public boolean ControlNumeroProduct(Integer id) {

        //obtener id del producto y su cantidad
        Producto productoActual = new Producto();
        productoActual = productoRepository.findById(id).orElse(null);

        if (productoActual.getCantidad() > 0) {

            return true;

        } else {
            return false;
        }

    }

}
