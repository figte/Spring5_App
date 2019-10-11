package com.personal.proyecto.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DetalleVenta
 */
@Entity
@Table(name = "detalles_ventas")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REMOVE,optional = false,fetch = FetchType.EAGER)
    private Venta venta;
   
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Producto producto;
    private Integer cantidad;

    public DetalleVenta() {
    }
    
    public DetalleVenta(Venta venta,Producto producto,Integer cantidad) {
        this.venta=venta;
        this.producto=producto;
        this.cantidad=cantidad;
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
     * @param venta the venta to set
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    /**
     * @return the venta
     */
    public Venta getVenta() {
        return venta;
    }
    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }
    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }
}
