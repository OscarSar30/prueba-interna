package com.banco.servicio.cliente.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.banco.servicio.cliente.controller.CuentaController;
import com.banco.servicio.cliente.model.ActualizarCuenta;
import com.banco.servicio.cliente.model.CrearCuenta;
import com.banco.servicio.cliente.model.GetCuentaByNumeroCuenta;
import com.banco.servicio.cliente.model.GetCuentas;
import com.banco.servicio.cliente.service.CuentaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CuentaApiImpl implements CuentaController{
	
	@Autowired
	CuentaService cuentaService;

	@Override
	public Mono<ResponseEntity<GetCuentaByNumeroCuenta>> consultarCuentaPorNumeroCuenta(String numeroCuenta) {
		return cuentaService.consultarCuentaPorNumeroCuenta(numeroCuenta);
	}

	@Override
	public Mono<ResponseEntity<Flux<GetCuentas>>> consultarCuentas() {
		return cuentaService.consultarCuentas();
	}

	@Override
	public Mono<ResponseEntity<Void>> actualizarCuenta(Mono<ActualizarCuenta> body) {
		return body
				.flatMap(request -> cuentaService.actualizarCuenta(request));
	}

	@Override
	public Mono<ResponseEntity<Flux<GetCuentas>>> consultarCuentasPorIdentificacion(String identificacion) {
		return cuentaService.consultarCuentasPorIdentificacion(identificacion);
	}

	@Override
	public Mono<ResponseEntity<Void>> crearCuenta(Mono<CrearCuenta> body) {
		return body
				.flatMap(request -> cuentaService.crearCuenta(request));
	}

}
