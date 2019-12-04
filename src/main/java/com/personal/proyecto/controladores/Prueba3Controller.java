package com.personal.proyecto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Prueba3Controller
 */
@Controller
@RequestMapping("prueba3")
public class Prueba3Controller {

    
     @GetMapping(value="vista")
     public String getVista() {
         return new String("prueba3");
     }

     @GetMapping(value="vista2")
     public String getVista2() {
         return new String("vistaParcial");
     }
     @GetMapping(value="vista3")
     public String getVista3() {
         return new String("operaciones");
     }
     
     
}