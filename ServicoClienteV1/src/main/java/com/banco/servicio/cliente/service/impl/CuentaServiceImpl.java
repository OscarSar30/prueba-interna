package com.banco.servicio.cliente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banco.servicio.cliente.error.ClienteExcepcion;
import com.banco.servicio.cliente.mapper.CuentaMapper;
import com.banco.servicio.cliente.model.ActualizarCuenta;
import com.banco.servicio.cliente.model.CrearCuenta;
import com.banco.servicio.cliente.model.GetCuentaByNumeroCuenta;
import com.banco.servicio.cliente.model.GetCuentas;
import com.banco.servicio.cliente.repository.ClienteRepository;
import com.banco.servicio.cliente.repository.CuentaRepository;
import com.banco.servicio.cliente.repository.PersonaRepository;
import com.banco.servicio.cliente.service.CuentaService;

import io.vavr.Tuple2;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CuentaServiceImpl implements CuentaService{
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	CuentaRepository cuentaRepository;
	
	@Autowired
	private CuentaMapper mapper;

	@Override
	public Mono<ResponseEntity<GetCuentaByNumeroCuenta>> consultarCuentaPorNumeroCuenta(String numeroCuenta) {
		log.info("Inicia proceso de consultar cuenta por numero de cuenta");
		return cuentaRepository.findByNumeroCuenta(numeroCuenta)
				.switchIfEmpty(Mono.error(ClienteExcepcion.NOT_FOUND_DATA))
				.flatMap(cuentaEntity -> clienteRepository.findPersonaIdByClienteId(cuentaEntity.getClienteId())
						.switchIfEmpty(Mono.error(ClienteExcepcion.NOT_FOUND_DATA))
						.map(response -> new Tuple2<>(cuentaEntity, response))
						.flatMap(objects -> personaRepository.findById(objects._2())
								.map(persona -> mapper.entitiesToGetCuenta(objects._1(), persona)))
				).map(response -> ResponseEntity.status(HttpStatus.OK).body(response));
	}

	@Override
	public Mono<ResponseEntity<Flux<GetCuentas>>> consultarCuentas() {
		log.info("Inicia proceso de consultar todos las cuentas");
		return cuentaRepository.findAll()
				.switchIfEmpty(Mono.error(ClienteExcepcion.NOT_FOUND_DATA))
				.map(entities -> mapper.entityToGetCuenta(entities))
				.collectList()
				.map(Flux::fromIterable)
				.map(ResponseEntity::ok);
	}

	@Override
	public Mono<ResponseEntity<Flux<GetCuentas>>> consultarCuentasPorIdentificacion(String identificacion) {
		log.info("Inicia proceso de consultar todos las cuentas por identificacion");
		return personaRepository.findByIdentificacion(identificacion)
				.flatMap(personaEntity -> clienteRepository.findClienteIdByPersonaId(personaEntity.getPersonaId())
						.map(clienteId -> new Tuple2<>(clienteId, personaEntity))
						.flatMap(objects -> cuentaRepository.findByClienteId(objects._1())
								.switchIfEmpty(Mono.error(ClienteExcepcion.NOT_FOUND_DATA))
								.map(entities -> mapper.entitiesToGetCuentaByIdentificacion(entities, objects._2()))
								.collectList()
								.map(Flux::fromIterable)
								.map(ResponseEntity::ok)
								)
						);
	}

	@Override
	public Mono<ResponseEntity<Void>> crearCuenta(CrearCuenta request) {
		log.info("Inicia proceso de crear cuenta");
		return clienteRepository.existsById(request.getClienteId())
				.flatMap(xBoolean -> {
					if(Boolean.TRUE.equals(xBoolean)) {
						log.info("Cliente existe");
						return cuentaRepository.save(mapper.crearCuentaRequestToCuentaEntity(request));
					} else {
						log.error("Cliente no existe");
						return Mono.error(ClienteExcepcion.NOT_FOUND_DATA);
					}
					
				}).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));
	}

	@Override
	public Mono<ResponseEntity<Void>> actualizarCuenta(ActualizarCuenta request) {
		log.info("Inicia proceso de actualizar cuenta");
		return cuentaRepository.findByNumeroCuenta(request.getNumeroCuenta())
				.flatMap(cuentaEntity -> {
					if(cuentaEntity!= null) {
						log.info("Se actualizará cuenta");
						return cuentaRepository.save(mapper.actualizarCuentaRequestToCuentaEntity(request, cuentaEntity));
					} else {
						log.error("Cuenta ingresada con existe");
						return Mono.error(ClienteExcepcion.NOT_FOUND_DATA);
					}
				}).thenReturn(new ResponseEntity<>(HttpStatus.OK));
	}

}
