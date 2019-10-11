package com.personal.proyecto.controladores;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.personal.proyecto.entidades.DetalleVenta;
import com.personal.proyecto.entidades.Venta;
import com.personal.proyecto.repositorios.IClienteRepository;
import com.personal.proyecto.repositorios.IOrdenRepository;
import com.personal.proyecto.repositorios.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * Prueba2Controller
 */
@Controller
@RequestMapping("prueba2")
class Prueba2Controller {
   
    @Autowired
    IOrdenRepository rOrden;
    @Autowired
    IClienteRepository rCliente;
    @Autowired
    IProductoRepository rProducto;
    /**
     * constructor
     */
    public Prueba2Controller() {
        
    }
    /**
     * 
     * @return String
     */
    @GetMapping(value="prueba2")
    public String prueba2(Model model ) {
        model.addAttribute("p", "un parametreo");
        model.addAttribute("p2", "hola");
        return new String("prueba2");
    }
    
     @GetMapping("prueba3")
     public String prueba3() {
        return "prueba3";
     }

     @GetMapping(value="pruebaMaestro")
     public String pruebaMaestro() {

        //objeto venta
            Venta v=new Venta();
            v.setFecha(new Date(2019,06,2));
            v.setCliente(rCliente.findById(1).get());
            
        //lista estatica de detalles
            List<DetalleVenta> l=new ArrayList<>();
            l.add(new DetalleVenta(
                v, 
                rProducto.findById(1).get(),
                5));
            l.add(new DetalleVenta(
                    v, 
                    rProducto.findById(2).get(),
                    3));    

           //agregando detalles a la venta         
            v.setDetalles_venta(l);
            
            rOrden.save(v);
            
         return new String("vista01");
     }
     
}