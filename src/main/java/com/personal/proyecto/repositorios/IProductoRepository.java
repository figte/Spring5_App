package com.personal.proyecto.repositorios;

import com.personal.proyecto.entidades.Producto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IProductoRepository
 */
@Repository
public interface IProductoRepository extends CrudRepository<Producto,Integer>{
    
}