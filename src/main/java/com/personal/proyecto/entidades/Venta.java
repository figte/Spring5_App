
package com.personal.proyecto.entidades;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Venta
 */
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "venta")
    private List<DetalleVenta> detalles_venta;

    public Venta() {        
    }

    public Venta(Date fecha,Cliente cliente) {
        this.fecha=fecha;
        this.cliente=cliente;
    }

    /**
     * @param detalles_venta the detalles_venta to set
     */
    public void setDetalles_venta(List<DetalleVenta> detalles_venta) {
        this.detalles_venta = detalles_venta;
    }

    /**
     * @return the detalles_venta
     */
    public List<DetalleVenta> getDetalles_venta() {
        return detalles_venta;
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
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
}