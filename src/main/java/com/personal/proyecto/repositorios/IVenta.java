package com.personal.proyecto.repositorios;

import com.personal.proyecto.entidades.Venta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IVenta
 */
@Repository
public interface IVenta extends CrudRepository<Venta,Integer> {

    
}