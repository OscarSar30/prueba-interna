package com.banco.servicio.cliente.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.banco.servicio.cliente.repository.entity.ClienteEntity;
import com.banco.servicio.cliente.repository.entity.ClienteModelEntity;

import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends ReactiveCrudRepository<ClienteModelEntity, Integer>{

	Mono<ClienteEntity> findByPersonaId(Integer idPersona);

	@Query("SELECT COUNT(P.IDENTIFICACION) > 0 FROM PERSONA P WHERE P.IDENTIFICACION = :identificacion")
	Mono<Boolean> findByIdentificacionUnica(String identificacion);
	
	@Query("SELECT CLIENTES.PERSONA_ID FROM CLIENTES WHERE CLIENTES.CLIENTE_ID = :clienteId LIMIT 1")
	Mono<Integer> findPersonaIdByClienteId (Integer clienteId);
	
	@Query("SELECT CLIENTES.CLIENTE_ID FROM CLIENTES WHERE CLIENTES.PERSONA_ID = :personaId LIMIT 1")
	Mono<Integer> findClienteIdByPersonaId (Integer personaId);

}
