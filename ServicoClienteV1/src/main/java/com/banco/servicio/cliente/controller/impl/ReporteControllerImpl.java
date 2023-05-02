/**
 * 
 */
package com.banco.servicio.cliente.controller.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.banco.servicio.cliente.controller.ReporteController;
import com.banco.servicio.cliente.model.EstadoCuentaResponse;
import com.banco.servicio.cliente.service.IReporteService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class ReporteControllerImpl implements ReporteController {
    
    @Autowired
    IReporteService reporteSvc;

	@Override
	public Mono<ResponseEntity<Flux<EstadoCuentaResponse>>> consultarEstadoCuenta(String identificacion, Date fechaDesde, Date fechaHasta) {
		return reporteSvc.consultarEstadoCuenta(identificacion, fechaDesde, fechaHasta);
	}

}
