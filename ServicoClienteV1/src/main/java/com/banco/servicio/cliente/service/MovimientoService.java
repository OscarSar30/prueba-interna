package com.banco.servicio.cliente.service;

import org.springframework.http.ResponseEntity;

import com.banco.servicio.cliente.model.CrearMovimiento;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuenta;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuentaAndTipo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovimientoService {

	Mono<ResponseEntity<Flux<GetMovimientosByNumeroCuentaAndTipo>>> consultarMovimientosPorCuentaTipoMovimiento(
			String numeroCuenta, String tipoMovimiento);

	Mono<ResponseEntity<Flux<GetMovimientosByNumeroCuenta>>> consultarMovimientosPorNumeroCuenta(String numeroCuenta);

	Mono<ResponseEntity<Void>> crearMovimiento(CrearMovimiento request);

}
