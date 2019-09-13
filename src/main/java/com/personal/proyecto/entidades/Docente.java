package com.personal.proyecto.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "docentes")
public class Docente {
	@Id
	@NonNull
	private Integer id;
	
	@Column
	@Max(100)
	@NonNull
	@NotBlank(message = "Campo requerido")	
	private String nombre;
	
	@Max(100)
	@Nullable
	private String especialidad;
	
	
	//contructores
	
	public Docente() {
		
	}

	public Docente(Integer id, String nombre, String especialidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especialidad = especialidad;
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
}
