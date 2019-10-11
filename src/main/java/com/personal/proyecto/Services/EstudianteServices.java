package com.personal.proyecto.Services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.personal.proyecto.entidades.Estudiante;
import com.personal.proyecto.repositorios.IEstudianteRepository;

@Service
public class EstudianteServices {

	@Autowired //se inyecta  implementacion del objeto
	IEstudianteRepository er;
	
	//obtener todos los registros
	public List<Estudiante> listar(){
		return (List<Estudiante>) er.findAll();
	}
	
	//guardar registros
	@Transactional
	public boolean guardar(Estudiante e) {
		try {
			er.save(e);
			return true;
		} catch (Exception e2) {
			System.err.println("ERROR: "+e2.getMessage());
			return false;
		}
	}	
	//eliminar
	
	//modificar
	
	//buscar
	
}
