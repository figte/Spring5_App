package com.personal.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cliente
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String nombre;
    private String telefono;
    private String direccion;

    public Cliente() {

    }

    public Cliente(String nombre,String telefono,String direccion){
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        Id = id;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    
}