package com.personal.proyecto.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("prueba")
public class PruebaController {

	
	@RequestMapping("holaMundo")
	//String ...representa el nombre de una vista, que esta guardada en la carpeta 'templates'
	public String holaMundo(){
		return "holaMundo";
	}

	//@RequestMapping(value = "vista",method = RequestMethod.GET)
	@GetMapping("vista")
	public String otraVista(Model m) {
		//Mandando parametros a la vista con el objeto de tipo Model
		String v="Soy otro parametro desde un controlador";	
		m.addAttribute("v",v);
		
		m.addAttribute("parametro", "Soy un parametro desde el controlador");
		
		return "vista01";
	}
	
	//EJEMPLOS------------------------------------------------------
	@GetMapping("listar")
	public String lista() {
		return "lista";
	}
	
	@PostMapping("guardar")
	public String guardar() {
		return "guardar";
	}
	//----------------------------------------------------------------
	
	//RUTA PARA MOSTRAR VISTA.
	@GetMapping("operaciones")
	public String mostrarOperaciones() {
		return "operaciones";
	}
	
	//RUTA PARA PROCESAR LA OPERACION
	@PostMapping("operaciones")
	public String procesarOperaciones(Model m,
			@RequestParam("n1") Double n1,
			@RequestParam("n2") Double n2) {
		
		//recibiendo datos de la peticion
		//Double n1=Double.parseDouble(request.getParameter("n1"));
		//Double n2=Double.parseDouble(request.getParameter("n2"));
		m.addAttribute("resultado", (n1+n2));
		return "Operaciones";
	}
	
	@RequestMapping("suma/{n1}/{n2}")
	public ModelAndView suma( 
			@PathVariable(value = "n1") Double n1,
			@PathVariable(value = "n2") Double n2,
			Model m){
		
		//objeto para manipular la vista a retornar 
		//y lo que se le pasara como  modelo de datos.
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("vista01"); //indicando vista a retornar
		mv.setStatus(HttpStatus.OK);
		m.addAttribute("r",(n1+n2)); //agregando dato que llegara
									// a la vista a retornar.
		return mv;
	}

}
