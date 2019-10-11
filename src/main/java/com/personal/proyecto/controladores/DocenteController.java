package com.personal.proyecto.controladores;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.personal.proyecto.entidades.Docente;
import com.personal.proyecto.entidades.Especialidad;
import com.personal.proyecto.repositorios.IDocenteRepository;
import com.personal.proyecto.repositorios.IEspecialidaRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("docente")
public class DocenteController {

	//intancia para el acceso a la persistencia de datos
	@Autowired
	IDocenteRepository erDocente;

	@Autowired
	IEspecialidaRepository erEspecialidad;
	
	@GetMapping("index")
	public String index(Model m) {
		//enviamos a la vista los registros de docentes 
		//obtenbidos de la base de datos
		m.addAttribute("items",(List<Docente>) erDocente.findAll());
		return "docentes/index";
	}

	@GetMapping(value="guardar")
	public String guardarVista(Model model) {
		List<Especialidad> especialidades=(List<Especialidad>) erEspecialidad.findAll();
		model.addAttribute("especialidades", especialidades);
		return new String("docentes/guardar");
	}

	@PostMapping(value="guardar")
	public String guardar(@RequestParam String nombre,@RequestParam Integer especialidad) {
		//creando objeto de docente a guardar
		@Valid Docente d=new Docente();
		d.setNombre(nombre); //asignando nombre

		//buscando especialidad referenciada
		Especialidad e=erEspecialidad.findById(especialidad).get();

		d.setEspecialidad(e); //asignando especialidad
		erDocente.save(d); //guardando el docente

			//redireccionando
		return "redirect:/docente/index";
	}

	@GetMapping(value="modificar/{id}")
	public String modificarVista( @PathVariable Integer id,Model model) {
		Docente d=erDocente.findById(id).get();
		model.addAttribute("item", d);
		List<Especialidad> especialidades=(List<Especialidad>) erEspecialidad.findAll();
		model.addAttribute("especialidades", especialidades);
		return new String("docentes/modificar");
	}

	@PostMapping(value="modificar")
	public String modificar(@RequestParam Integer id,@RequestParam String nombre, @RequestParam Integer especialidad){
		//creando objeto de docente a modificar
		Docente d=new Docente();
		d.setId(id);
		d.setNombre(nombre); //asignando nombre
		//buscando especialidad referenciada
		Especialidad e=erEspecialidad.findById(especialidad).get();
		d.setEspecialidad(e); //asignando especialidad
	
		erDocente.save(d); //guardando el docent    
		
		return "redirect:/docente/index";
	}

	@GetMapping(value="eliminar/{id}")
	public String eliminar(@PathVariable Integer id) {
		Docente d=erDocente.findById(id).get();
		erDocente.delete(d);
		return new String("redirect:/docente/index");
	}
	
}
