package com.banco.servicio.cliente.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.banco.servicio.cliente.repository.entity.PersonaEntity;

import reactor.core.publisher.Mono;

@Repository
public interface PersonaRepository extends ReactiveCrudRepository<PersonaEntity, Integer>{
	
	Mono<PersonaEntity> findByIdentificacion(String identificacion);

}
