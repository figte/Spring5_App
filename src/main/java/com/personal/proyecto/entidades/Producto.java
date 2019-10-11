
package com.personal.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Producto
 */
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private Double precio;
    private Integer existencias;

    public Producto() {
        
    }

    public Producto(String nombre,Double precio,Integer existencias) {
        this.nombre=nombre;
        this.precio=precio;
        this.existencias=existencias;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
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
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }
    /**
     * @param existencias the existencias to set
     */
    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }
    /**
     * @return the existencias
     */
    public Integer getExistencias() {
        return existencias;
    }
}