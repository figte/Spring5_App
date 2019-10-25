package com.personal.proyecto.controladores;

import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;

import com.personal.proyecto.entidades.Persona;
import com.personal.proyecto.repositorios.IPersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * PersonaController
 */
@Controller
@RequestMapping("persona")
public class PersonaController {

    // agregando referencia a capa de datos
    @Autowired
    IPersonaRepository rPersona;


    /**
     * 
     * Metodo para cargar vista 
     * @return String
     */
    @GetMapping(value="index")
   
    public String index() {
        return new String("ejemplo");
    }
    

    /**
     * Metodo para retornar el listado de registros
     * en un formato JSON segun la ruta establecida
     * @return List<Persona>
     */
    @GetMapping(value="all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Persona> getAll() {
        return (List<Persona>) rPersona.findAll();
    }

    @PostMapping(value="saveOrUpdate",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean save(
        @RequestParam Integer id,
        @RequestParam String nombre,
        @RequestParam String direccion,
        @RequestParam String telefono){
        
        Persona p=new Persona();

        if(id!=null)
            p.setId(id);
        p.setNombre(nombre);
        p.setDireccion(direccion);
        p.setTelefono(telefono);

        rPersona.save(p);

        return true;
    }
    
    @GetMapping(value="delete/{id}")
    @ResponseBody
    public Boolean delete(@PathVariable Integer id) {
        Persona p=rPersona.findById(id).get();
        rPersona.delete(p);
        return true;
    }
    
    @GetMapping(value="get/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Persona getMethodName(@PathVariable Integer id) {
        return rPersona.findById(id).get();
    }
    


}