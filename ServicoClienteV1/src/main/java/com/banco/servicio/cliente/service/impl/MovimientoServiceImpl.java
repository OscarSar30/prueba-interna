package com.banco.servicio.cliente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banco.servicio.cliente.error.ClienteExcepcion;
import com.banco.servicio.cliente.mapper.MovimientoConstants;
import com.banco.servicio.cliente.mapper.MovimientoMapper;
import com.banco.servicio.cliente.model.CrearMovimiento;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuenta;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuentaAndTipo;
import com.banco.servicio.cliente.repository.ClienteRepository;
import com.banco.servicio.cliente.repository.CuentaRepository;
import com.banco.servicio.cliente.repository.MovimientoRepository;
import com.banco.servicio.cliente.repository.PersonaRepository;
import com.banco.servicio.cliente.repository.entity.CuentaEntity;
import com.banco.servicio.cliente.repository.entity.MovimientoEntity;
import com.banco.servicio.cliente.service.MovimientoService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class MovimientoServiceImpl implements MovimientoService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	CuentaRepository cuentaRepository;

	@Autowired
	MovimientoRepository movimientoRepository;

	@Autowired
	private MovimientoMapper mapper;

	@Override
	public Mono<ResponseEntity<Flux<GetMovimientosByNumeroCuentaAndTipo>>> consultarMovimientosPorCuentaTipoMovimiento(
			String numeroCuenta, String tipoMovimiento) {
		log.info("Inicia proceso de consultar todos los movimientos por numero cuenta y tipo movimiento");
		return cuentaRepository.findByNumeroCuenta(numeroCuenta)
				.flatMap(cuentaEntity -> movimientoRepository
						.findByTipoMovimientoAndCuentaId(tipoMovimiento, cuentaEntity.getCuentaId())
						.switchIfEmpty(Mono.error(ClienteExcepcion.NOT_FOUND_DATA))
						.map(entities -> mapper.entitiesToGetMovimientosByFilters(cuentaEntity, entities)).collectList()
						.map(Flux::fromIterable).map(ResponseEntity::ok));
	}

	@Override
	public Mono<ResponseEntity<Flux<GetMovimientosByNumeroCuenta>>> consultarMovimientosPorNumeroCuenta(
			String numeroCuenta) {
		log.info("Inicia proceso de consultar todos los movimientos por numero cuenta");
		return cuentaRepository.findByNumeroCuenta(numeroCuenta)
				.flatMap(cuentaEntity -> movimientoRepository.findByCuentaId(cuentaEntity.getCuentaId())
						.map(entities -> mapper.entityToGetMovimientosByNumeroCuenta(entities)).collectList()
						.map(Flux::fromIterable).map(ResponseEntity::ok));
	}

	@Override
	public Mono<ResponseEntity<Void>> crearMovimiento(CrearMovimiento request) {
		log.info("Inicia proceso de crear movimiento");
		return cuentaRepository.findById(request.getCuentaId())
				.flatMap(cuentaEntity -> {
					if (cuentaEntity != null) {
						log.info("Cuenta existente");
						return cuentaRepository.findByNumeroCuenta(cuentaEntity.getTipoCuenta())
								.flatMap(entity -> movimientoRepository.findByCuentaIdAndFecha(entity.getCuentaId(), request.getFecha())
										.flatMap(movimiento -> validateData(request, movimiento, entity)));
								
					} else {
						log.error("No existe la cuenta");
						return Mono.error(ClienteExcepcion.NOT_FOUND_DATA);
						}
				});
	}

	private Mono<ResponseEntity<Void>> validateData(CrearMovimiento request,
													MovimientoEntity infoMovimiento, 
													CuentaEntity infoCuenta) {
		if (request.getTipoMovimiento().equals(MovimientoConstants.TIPO_RETIRO)) {
			log.info("Es retiro");
			return isRetiro(request, infoMovimiento, infoCuenta);
		} else if (request.getTipoMovimiento().equals(MovimientoConstants.TIPO_DEPOSITO)) {
			log.info("Es deposito");
			return isDeposito(request, infoMovimiento, infoCuenta);
		}
		return Mono.error(ClienteExcepcion.NOT_FOUND_DATA);
	}

	private Mono<ResponseEntity<Void>> isRetiro(CrearMovimiento request, 
												MovimientoEntity infoMovimiento, 
												CuentaEntity infoCuenta) {
		return movimientoRepository.findValorByFechaAndTipoAndNumeroCuenta(request.getFecha(), "Retiro", infoCuenta.getNumeroCuenta())
				.flatMap(valor -> {
					if(infoMovimiento == null) {
						// Si el saldo es cero, y va a realizar una transacción débito, debe desplegar
						// mensaje “Saldo no disponible”
						if (infoCuenta.getSaldoInicial() == 0.00)
							Mono.just(Mono.error(ClienteExcepcion.ERROR_SALDO_EN_CERO));
						
						// Si el cupo disponible ya se cumplió no debe permitir realizar un debito y
						// debe desplegar un mensaje “Cupo diario Excedido”
						if (Math.abs(Double.parseDouble(valor)) >= MovimientoConstants.VALOR_TOPE) {
							Mono.just(Mono.error(ClienteExcepcion.ERROR_MAXIMO_CUPO));
						}
						CrearMovimiento crearMovimiento = new CrearMovimiento();
						crearMovimiento.setCuentaId(request.getCuentaId());
						crearMovimiento.setSaldo(infoCuenta.getSaldoInicial() - request.getValor());
						crearMovimiento.setValor(-(request.getValor()));
						crearMovimiento.setSaldoInicial(infoCuenta.getSaldoInicial());
						return movimientoRepository.save(mapper.crearMovimientoRequestToEnity(crearMovimiento))
								.thenReturn(new ResponseEntity<>(HttpStatus.CREATED));
						
					} else if (infoMovimiento.getSaldo() == 0.00)
						Mono.just(Mono.error(ClienteExcepcion.ERROR_SALDO_EN_CERO));
					return Mono.error(ClienteExcepcion.NOT_FOUND_DATA);
					
				});
		
	}

	private Mono<ResponseEntity<Void>> isDeposito(CrearMovimiento request, 
												  MovimientoEntity infoMovimiento, 
												  CuentaEntity infoCuenta) {
		if (infoMovimiento == null) {
			request.setCuentaId(infoCuenta.getCuentaId());
			request.setSaldo(infoCuenta.getSaldoInicial() + request.getValor());
			request.setValor(request.getValor());
			request.setSaldoInicial(infoCuenta.getSaldoInicial());
			return movimientoRepository.save(mapper.crearMovimientoRequestToEnity(request))
					.thenReturn(new ResponseEntity<>(HttpStatus.CREATED));
			
		} else {
			request.setCuentaId(infoCuenta.getCuentaId());
			request.setSaldo(infoMovimiento.getSaldo() + request.getValor());
			request.setValor(request.getValor());
			request.setSaldoInicial(infoMovimiento.getSaldo());
			return movimientoRepository.save(mapper.crearMovimientoRequestToEnity(request))
					.thenReturn(new ResponseEntity<>(HttpStatus.CREATED));
		}
	}

}
