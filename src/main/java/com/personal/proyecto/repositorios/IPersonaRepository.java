
package com.personal.proyecto.repositorios;

import com.personal.proyecto.entidades.Persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * IPersonaRepository
 */
@Repository
public interface IPersonaRepository extends CrudRepository<Persona,Integer>{

    
}