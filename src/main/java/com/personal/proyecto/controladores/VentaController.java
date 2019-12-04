package com.personal.proyecto.controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.personal.proyecto.Services.VentaService;
import com.personal.proyecto.entidades.Cliente;
import com.personal.proyecto.entidades.DetalleVenta;
import com.personal.proyecto.entidades.Producto;
import com.personal.proyecto.entidades.Venta;

import org.hibernate.annotations.AccessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




/**
 * VentaController
 */
@Controller
@RequestMapping("ventas")
public class VentaController {

    @Autowired
    VentaService sVenta;
  
    //listado en memoria de detalles de la venta a guardar
    public static List<DetalleVenta> detalles=new ArrayList<DetalleVenta>();

    public VentaController() {
       
    }
    @GetMapping(value="allVentas")
    @ResponseBody
    @CrossOrigin
    public Object allVentas() {
    
        List< HashMap<String,Object>> objetos=new ArrayList<>();
    

        List<Venta> l=sVenta.getAllVenta();

        for (Venta venta : l) {
            HashMap<String,Object> hm=new HashMap<>();
            hm.put("id", venta.getId().toString());
            hm.put("fecha", venta.getFecha().toString());
            hm.put("cliente",venta.getCliente().getNombre());
            hm.put("operaciones",""
                +"<button class='btn btn-warning ml-2 modificar'>Modificar</button>"
                +"<button class='btn btn-danger ml-2 eliminar'>Elmininar</button>"
            +"");

            objetos.add(hm);
        }
        
        return Collections.singletonMap("data", objetos);
    }


    @GetMapping(value="index")
    public String index(Model model) {
        return new String("/ventas/index");
    }

    @GetMapping(value="guardar")
    public String guardarMostrar(Model model,@RequestParam(required = false) Cliente cliente) {
        model.addAttribute("productos", sVenta.getAllProductos());
        model.addAttribute("clientes", sVenta.getAllClientes());
        model.addAttribute("cliente", cliente);
        detalles=new ArrayList<DetalleVenta>();
        //model.addAttribute("listaProductos", new ArrayList<Producto>());
        return new String("/ventas/guardar");
    }



    @PostMapping(value="cargarCliente")
    public String cargarCliente(@RequestParam Integer id,Model model) {
        model.addAttribute("cliente", sVenta.getCliente(id));
       // model.addAttribute("productos", sVenta.getAllProductos());
        //model.addAttribute("clientes", sVenta.getAllClientes());
        return "redirect:/ventas/guardar";
    }

    
    @GetMapping(value = "/api/clientes",produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Cliente> indexJSON() {
        return  sVenta.getAllClientes();
    }
    @GetMapping(value = "api/productos")
    @ResponseBody
    public List<Producto> productosJSON() {
        return  sVenta.getAllProductos();
    }
    
    @PostMapping(value="agregarDetalle")
    @ResponseBody
    @CrossOrigin
    public DetalleVenta agregarDetalle(@RequestParam Integer cantidad, 
                                  @RequestParam Integer idProducto) {
       DetalleVenta dv=new DetalleVenta();
       dv.setCantidad(cantidad);
       dv.setProducto(sVenta.getProducto(idProducto)); 
       detalles.add(dv);
        return dv;

    }

    @GetMapping(value="allDetalles",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin
    public List<DetalleVenta> getDetallesMemoria() {
        return detalles;

    }

    @PostMapping(value="save")
    @ResponseBody
    @CrossOrigin
    public Boolean save(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
                        @RequestParam Integer idCliente) {
   
        Venta entity=new Venta();
        entity.setCliente(sVenta.getCliente(idCliente));
        entity.setFecha(fecha);

        for (DetalleVenta detalleVenta : detalles) {
            detalleVenta.setVenta(entity);
        }

        entity.setDetalles_venta(detalles);

        try {
            sVenta.save(entity);
            return true;  
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }

      
    }
    
}