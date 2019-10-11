package com.personal.proyecto.repositorios;

import com.personal.proyecto.entidades.Cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IClienteRepository
 */
@Repository
public interface IClienteRepository extends CrudRepository<Cliente,Integer>{

    
}