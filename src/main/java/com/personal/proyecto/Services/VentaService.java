package com.personal.proyecto.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.personal.proyecto.entidades.Cliente;
import com.personal.proyecto.entidades.Producto;
import com.personal.proyecto.entidades.Venta;
import com.personal.proyecto.repositorios.IClienteRepository;
import com.personal.proyecto.repositorios.IProductoRepository;
import com.personal.proyecto.repositorios.IVenta;

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

    @Autowired
    IVenta rVenta;

    @Transactional
    public List<Venta> getAllVenta() {
        return (List<Venta>) rVenta.findAll();
    }


    @Transactional
    public Boolean save(Venta entity) {
        try {
            rVenta.save(entity);
            return true;
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println("Error: "+e.getMessage());
            return false;
        }
    }

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
    @Transactional
    public Producto getProducto(Integer id){
        return rProducto.findById(id).get();
    }
    
}