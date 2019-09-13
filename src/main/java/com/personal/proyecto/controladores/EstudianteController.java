package com.personal.proyecto.controladores;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.personal.proyecto.entidades.Estudiante;
import com.personal.proyecto.repositorios.IEstudianteRepository;

@Controller
@RequestMapping("estudiante")
public class EstudianteController {

	@Autowired
	IEstudianteRepository er;
	
//	@Autowired
//	EstudianteServices es;
	
	//constructor
//	public EstudianteController() {
//	
//		//Agregando datos por defecto al listado
//		Data.listadoEstudiantes.add(new Estudiante(01, "Juan Perez", "La chancla", 30));
//		Data.listadoEstudiantes.add(new Estudiante(02, "Jose Perez", "La chancla", 20));
//		Data.listadoEstudiantes.add(new Estudiante(03, "Maria Josefa", "Ataco", 21));
//	}
	
	@GetMapping("index")
	public String listar(Model m) {
		m.addAttribute("items",(List<Estudiante>) er.findAll());
		return "estudiantes/index";
	}
	
	@GetMapping("guardar")
	public String vistaGuardar() {
		return "estudiantes/guardar";
	}
	
	@PostMapping("guardar")
	public String guardar(@RequestParam Integer id,
			@RequestParam String nombre,
			@RequestParam String direccion,
			@RequestParam Integer edad) {
		//preccesando peticion
		Estudiante e=new Estudiante(id,nombre,direccion,edad);
		
		er.save(e);
		//Data.listadoEstudiantes.add(e);
		
		return "redirect:/estudiante/index";
	}

	
}
