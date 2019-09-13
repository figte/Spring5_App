package com.personal.proyecto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Prueba2Controller
 */
@Controller
@RequestMapping("prueba2")
class Prueba2Controller {
   
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
}