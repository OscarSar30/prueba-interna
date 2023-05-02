package com.banco.servicio.cliente.service;

import org.springframework.http.ResponseEntity;

import com.banco.servicio.cliente.model.ActualizarCuenta;
import com.banco.servicio.cliente.model.CrearCuenta;
import com.banco.servicio.cliente.model.GetCuentaByNumeroCuenta;
import com.banco.servicio.cliente.model.GetCuentas;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CuentaService {

	Mono<ResponseEntity<GetCuentaByNumeroCuenta>> consultarCuentaPorNumeroCuenta(String numeroCuenta);

	Mono<ResponseEntity<Flux<GetCuentas>>> consultarCuentas();

	Mono<ResponseEntity<Flux<GetCuentas>>> consultarCuentasPorIdentificacion(String identificacion);

	Mono<ResponseEntity<Void>> crearCuenta(CrearCuenta request);

	Mono<ResponseEntity<Void>> actualizarCuenta(ActualizarCuenta request);

}
