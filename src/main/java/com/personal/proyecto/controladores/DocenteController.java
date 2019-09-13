package com.personal.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.personal.proyecto.entidades.Docente;
import com.personal.proyecto.repositorios.IDocenteRepository;


@Controller
@RequestMapping("docente")
public class DocenteController {

	//intancia para el acceso a la persistencia de datos
	@Autowired
	IDocenteRepository er;
	
	@GetMapping("index")
	public String index(Model m) {
		//enviamos a la vista los registros de docentes 
		//obtenbidos de la base de datos
		m.addAttribute("items",(List<Docente>) er.findAll());
		
		return "docentes/index";
	}

	@GetMapping(value="guardar")
	public String guardarVista() {
		return new String("guardar");
	}
	
}
