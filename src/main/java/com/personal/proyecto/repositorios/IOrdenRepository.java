
package com.personal.proyecto.repositorios;

import com.personal.proyecto.entidades.Venta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IOrdenRepository
 */
@Repository
public interface IOrdenRepository extends CrudRepository<Venta,Integer>{

    
}