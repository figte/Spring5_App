package com.personal.proyecto.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.proyecto.entidades.Docente;

@Repository
public interface IDocenteRepository extends CrudRepository<Docente, Integer> {

}
