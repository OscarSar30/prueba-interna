package com.banco.servicio.cliente.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.banco.servicio.cliente.controller.MovimientoController;
import com.banco.servicio.cliente.model.CrearMovimiento;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuenta;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuentaAndTipo;
import com.banco.servicio.cliente.service.MovimientoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MovimientoApiImpl implements MovimientoController{
	
	@Autowired
	MovimientoService movimientoService;

	@Override
	public Mono<ResponseEntity<Flux<GetMovimientosByNumeroCuenta>>> consultarMovimientosPorNumeroCuenta(String numeroCuenta) {
		return movimientoService.consultarMovimientosPorNumeroCuenta(numeroCuenta);
	}

	@Override
	public Mono<ResponseEntity<Flux<GetMovimientosByNumeroCuentaAndTipo>>> consultarMovimientosPorCuentaTipoMovimiento(
			String numeroCuenta, String tipoMovimiento) {
		return movimientoService.consultarMovimientosPorCuentaTipoMovimiento(numeroCuenta, tipoMovimiento);
	}

	@Override
	public Mono<ResponseEntity<Void>> crearMovimiento(Mono<CrearMovimiento> body) {
		return body
				.flatMap(request ->movimientoService.crearMovimiento(request));
	}
	

}
