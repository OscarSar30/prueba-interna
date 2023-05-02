package com.banco.servicio.cliente.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.banco.servicio.cliente.controller.ClienteController;
import com.banco.servicio.cliente.model.GetClientes;
import com.banco.servicio.cliente.model.GetPersonaAll;
import com.banco.servicio.cliente.model.CrearCliente;
import com.banco.servicio.cliente.model.ActualizarCliente;
import com.banco.servicio.cliente.service.ClienteService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClienteApiImpl implements ClienteController{
	
	@Autowired
	ClienteService clienteService;

	@Override
	public Mono<ResponseEntity<GetClientes>> consultarClientePorIdentificacion(String identificacion) {
		return clienteService.consultarClientePorIdentificacion(identificacion);
	}

	@Override
	public Mono<ResponseEntity<Void>> eliminarCliente(Integer clienteId) {
		return clienteService.eliminarCliente(clienteId);
	}

	@Override
	public Mono<ResponseEntity<Flux<GetPersonaAll>>> consultarClientes() {
		return clienteService.consultarClientes();
	}

	@Override
	public Mono<ResponseEntity<Void>> crearCliente(Mono<CrearCliente> body) {
		return body
				.flatMap(request -> clienteService.crearCliente(request));
	}

	@Override
	public Mono<ResponseEntity<Void>> actualizarCliente(Mono<ActualizarCliente> body) {
		return body
				.flatMap(request -> clienteService.actualizarCliente(request));
	}

}
