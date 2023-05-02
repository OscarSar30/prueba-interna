/**
 * 
 */
package com.banco.servicio.cliente.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banco.servicio.cliente.error.ClienteExcepcion;
import com.banco.servicio.cliente.model.EstadoCuentaResponse;
import com.banco.servicio.cliente.repository.MovimientoRepository;
import com.banco.servicio.cliente.service.IReporteService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author osarcos
 *
 */
@Service
public class ReporteServiceImpl implements IReporteService {
	
	@Autowired
	MovimientoRepository movimientoRepository;
	
	@Override
	public Mono<ResponseEntity<Flux<EstadoCuentaResponse>>> consultarEstadoCuenta(String identificacion, Date fechaDesde, Date fechaHasta) {
		return movimientoRepository.findEstadoCuentaByFechas(identificacion, fechaDesde, fechaHasta)
				.switchIfEmpty(Mono.error(ClienteExcepcion.NOT_FOUND_DATA))
				.collectList()
				.map(Flux::fromIterable)
				.map(ResponseEntity::ok);
	}

}
