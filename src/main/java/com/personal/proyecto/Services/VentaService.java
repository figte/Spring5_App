package com.personal.proyecto.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.personal.proyecto.entidades.Cliente;
import com.personal.proyecto.entidades.Producto;
import com.personal.proyecto.repositorios.IClienteRepository;
import com.personal.proyecto.repositorios.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * VentaService
 */
@Service
public class VentaService {

    @Autowired
    IClienteRepository rCliente;
    @Autowired
    IProductoRepository rProducto;


    @Transactional
    public List<Cliente> getAllClientes(){
        return ( List<Cliente>) rCliente.findAll();
    }

    @Transactional
    public List<Producto> getAllProductos(){
        return ( List<Producto>) rProducto.findAll();
    }

    @Transactional
    public Cliente getCliente(Integer id){
        return rCliente.findById(id).get();
    }
    
}