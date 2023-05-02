package com.banco.servicio.cliente.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.banco.servicio.cliente.repository.entity.CuentaEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CuentaRepository extends ReactiveCrudRepository<CuentaEntity, Integer>{

	Mono<CuentaEntity> findByNumeroCuenta(String numeroCuenta);

	Flux<CuentaEntity> findByClienteId(Integer clienteId);
	
	
	
}
