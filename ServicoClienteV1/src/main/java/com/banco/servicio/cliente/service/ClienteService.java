package com.banco.servicio.cliente.service;

import org.springframework.http.ResponseEntity;

import com.banco.servicio.cliente.model.GetClientes;
import com.banco.servicio.cliente.model.GetPersonaAll;
import com.banco.servicio.cliente.model.CrearCliente;
import com.banco.servicio.cliente.model.ActualizarCliente;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {
	
	Mono<ResponseEntity<Void>> actualizarCliente(ActualizarCliente putCliente);

	Mono<ResponseEntity<GetClientes>> consultarClientePorIdentificacion(String identificacion);

	Mono<ResponseEntity<Flux<GetPersonaAll>>> consultarClientes();
		
	Mono<ResponseEntity<Void>> crearCliente(CrearCliente postCliente);
	
	Mono<ResponseEntity<Void>> eliminarCliente(Integer clienteId);

}
