package com.banco.servicio.cliente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banco.servicio.cliente.error.ClienteExcepcion;
import com.banco.servicio.cliente.mapper.ClienteMapper;
import com.banco.servicio.cliente.model.GetClientes;
import com.banco.servicio.cliente.model.GetPersonaAll;
import com.banco.servicio.cliente.model.CrearCliente;
import com.banco.servicio.cliente.model.ActualizarCliente;
import com.banco.servicio.cliente.repository.ClienteRepository;
import com.banco.servicio.cliente.repository.PersonaRepository;
import com.banco.servicio.cliente.repository.entity.ClienteModelEntity;
import com.banco.servicio.cliente.repository.entity.PersonaEntity;
import com.banco.servicio.cliente.service.ClienteService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	private ClienteMapper mapper;

	@Override
	public Mono<ResponseEntity<Void>> actualizarCliente(ActualizarCliente putCliente) {
		log.info("Inicia proceso de actualizar cliente");
		return clienteRepository.existsById(putCliente.getClienteId())
				.flatMap(resultado -> {
					if(Boolean.TRUE.equals(resultado)) {
						log.info("Cliente existe");
						return personaRepository.findByIdentificacion(putCliente.getIdentificacion())
								.flatMap(entity -> {
									if(entity.getIdentificacion() == putCliente.getIdentificacion()) {
										log.error("Cédula de cliente ya existe");
										return Mono.error(ClienteExcepcion.ERROR_CEDULA_EXISTE);
									} else {
										return clienteRepository.save(putRequestToClienteEntity(putCliente, entity))
												.flatMap(transformer -> personaRepository.save(mapper.putRequestToPersonaEntity(putCliente, entity)));
									}
								});
					} else {
						log.error("Cliente no encontrado");
						return Mono.error(ClienteExcepcion.NOT_FOUND_DATA);
					}
					
				})
				.thenReturn(new ResponseEntity<>(HttpStatus.OK));
	}
	
	private ClienteModelEntity putRequestToClienteEntity (ActualizarCliente request, PersonaEntity entity) {
		ClienteModelEntity clienteEntity = new ClienteModelEntity();
		clienteEntity.setContrasenia(request.getContrasenia());
		clienteEntity.setEstado(request.getEstado());
		clienteEntity.setPersonaId(entity.getPersonaId());
		clienteEntity.setClienteId(request.getClienteId());
		return clienteEntity;
	}

	@Override
	public Mono<ResponseEntity<GetClientes>> consultarClientePorIdentificacion(String identificacion) {
		log.info("Inicia proceso de consultar cliente por identificación");
		return personaRepository.findByIdentificacion(identificacion)
				.switchIfEmpty(Mono.error(ClienteExcepcion.NOT_FOUND_DATA))
				.flatMap(personaEntity -> clienteRepository.findByPersonaId(personaEntity.getPersonaId())
						.map(clienteEntity -> mapper.entityToGetClientes(personaEntity, clienteEntity))
						.doOnSuccess(x -> log.info("Se obtienen consulta desde base"))
						.doOnError(error -> log.error("Error: {}", error))
						.map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
						);
	}

	@Override
	public Mono<ResponseEntity<Flux<GetPersonaAll>>> consultarClientes() {
		log.info("Inicia proceso de consultar todos los clientes");
		return personaRepository.findAll()
						.map(entities -> mapper.entityToGetClientesAll(entities))
						.collectList()
						.map(Flux::fromIterable)
						.map(ResponseEntity::ok);
				
				
	}

	@Override
	public Mono<ResponseEntity<Void>> crearCliente(CrearCliente postCliente) {
		log.info("Inicia proceso de crear cliente");
		return clienteRepository.findByIdentificacionUnica(postCliente.getIdentificacion())
				.flatMap(resultado -> {
					if(Boolean.TRUE.equals(resultado)) {
						log.error("Cédula de cliente ya existe");
						return Mono.error(ClienteExcepcion.ERROR_CEDULA_EXISTE);
					}else {
						log.info("Cliente creado");
						return personaRepository.save(mapper.postRequestToPersonaEntity(postCliente))
								.flatMap(response -> clienteRepository.save(postRequestToClienteEntity(postCliente,response)));
					}
				})
				.thenReturn(new ResponseEntity<>(HttpStatus.CREATED));
	}
	
	private ClienteModelEntity postRequestToClienteEntity (CrearCliente request, PersonaEntity entity) {
		ClienteModelEntity clienteEntity = new ClienteModelEntity();
		clienteEntity.setContrasenia(request.getContrasenia());
		clienteEntity.setEstado(request.getEstado());
		clienteEntity.setPersonaId(entity.getPersonaId());
		return clienteEntity;
	}

	@Override
	public Mono<ResponseEntity<Void>> eliminarCliente(Integer clienteId) {
		log.info("Inicia proceso de eliminar cliente por id");
		return clienteRepository.existsById(clienteId)
				.flatMap(resultado -> {
					if(Boolean.TRUE.equals(resultado)) {
						log.info("Cliente eliminado");
						return clienteRepository.findPersonaIdByClienteId(clienteId)
								.flatMap(personaId -> deletePersona(personaId, clienteId));
					}else {
						log.error("Cliente no encontrado");
						return Mono.error(ClienteExcepcion.NOT_FOUND_DATA);
					}
				})
				.thenReturn(new ResponseEntity<>(HttpStatus.OK));
	}
	
	private Mono<Void> deletePersona(Integer personaId, Integer clienteId) {
		return clienteRepository.deleteById(clienteId)
				.flatMap(x -> personaRepository.deleteById(personaId));
	}

}
