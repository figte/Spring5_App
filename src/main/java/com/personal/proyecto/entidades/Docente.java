package com.personal.proyecto.entidades;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "docentes")
public class Docente {
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@NotNull(message = "campo requerido")
	private String nombre;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Especialidad especialidad;
	
	//contructores
	public Docente() {
		
	}

	public Docente(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	//setter y getter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param especialidad the especialidad to set
	 */
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	/**
	 * @return the especialidad
	 */
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	
	
}
