package com.personal.proyecto.controladores;

import java.util.ArrayList;
import java.util.List;

import com.personal.proyecto.Services.VentaService;
import com.personal.proyecto.entidades.Cliente;
import com.personal.proyecto.entidades.Producto;

import org.hibernate.annotations.AccessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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


    @GetMapping(value="guardar")
    public String guardarMostrar(Model model,@RequestParam(required = false) Cliente cliente) {
        model.addAttribute("productos", sVenta.getAllProductos());
        model.addAttribute("clientes", sVenta.getAllClientes());
        model.addAttribute("cliente", cliente);
        //model.addAttribute("listaProductos", new ArrayList<Producto>());
        return new String("/ventas/guardar");
    }

    @GetMapping(value="index")
    public String listar(Model model) {
        return new String("ventas/index");
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
    
    
}