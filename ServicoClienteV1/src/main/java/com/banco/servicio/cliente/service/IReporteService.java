/**
 * 
 */
package com.banco.servicio.cliente.service;

import java.util.Date;

import org.springframework.http.ResponseEntity;

import com.banco.servicio.cliente.model.EstadoCuentaResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author osarcos
 *
 */
public interface IReporteService {

	Mono<ResponseEntity<Flux<EstadoCuentaResponse>>> consultarEstadoCuenta(String identificacion, Date fechaDesde, Date fechaHasta);

}
