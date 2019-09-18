package com.personal.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


@Entity
@Table(name = "estudiantes")
public class Estudiante {

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "campo requerido")
	private String nombre;
	
	@Nullable
	private String direccion;
	
	
	@NotNull(message = "campo requerido")
	private Integer edad;

	//Constructores
	 public Estudiante() {
	}
	
	public Estudiante(Integer id, String nombre, String direccion, Integer edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.edad = edad;
	}

	//Setter and Getter
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
}
