package com.banco.servicio.cliente.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.banco.servicio.cliente.mapper.ClienteMapper;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuenta;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuentaAndTipo;
import com.banco.servicio.cliente.repository.ClienteRepository;
import com.banco.servicio.cliente.repository.CuentaRepository;
import com.banco.servicio.cliente.repository.MovimientoRepository;
import com.banco.servicio.cliente.repository.PersonaRepository;
import com.banco.servicio.cliente.utils.MockData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {MovimientoServiceImplTest.class})
class MovimientoServiceImplTest {
	
	@Mock
	private PersonaRepository personaRepository;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Mock
	private CuentaRepository cuentaRepository;
	
	@Mock
	private MovimientoRepository movimientoRepository;
	
	@Mock
	private ClienteMapper mapper;
	
	@InjectMocks
	private MovimientoServiceImpl movimientoServiceImpl;
	
	
	@Test
	void consultarMovimientosPorCuentaTipoMovimientoOk() {
		Mockito.when(cuentaRepository.findByNumeroCuenta(Mockito.anyString()))
				.thenReturn(Mono.just(MockData.buildCuentaEntity()));
		
		Mockito.when(movimientoRepository.findByTipoMovimientoAndCuentaId(Mockito.anyString(), Mockito.anyInt()))
				.thenReturn(Flux.just(MockData.buildMovimientoEntity()));
		
		ResponseEntity<Flux<GetMovimientosByNumeroCuentaAndTipo>> response = ResponseEntity.status(HttpStatus.OK).body(Flux.just(new GetMovimientosByNumeroCuentaAndTipo()));
		
		StepVerifier.create(movimientoServiceImpl.consultarMovimientosPorCuentaTipoMovimiento(MockData.NUMERO_CUENTA, "Ahorros"))
						.expectNext(response)
						.verifyComplete();
		
	}
	
	@Test
	void consultarMovimientosPorNumeroCuentaOk() {
		Mockito.when(cuentaRepository.findByNumeroCuenta(Mockito.anyString()))
				.thenReturn(Mono.just(MockData.buildCuentaEntity()));
		
		Mockito.when(movimientoRepository.findByCuentaId(Mockito.anyInt()))
				.thenReturn(Flux.just(MockData.buildMovimientoEntity()));
		
		ResponseEntity<Flux<GetMovimientosByNumeroCuenta>> response = ResponseEntity.status(HttpStatus.OK).body(Flux.just(new GetMovimientosByNumeroCuenta()));
		
		StepVerifier.create(movimientoServiceImpl.consultarMovimientosPorNumeroCuenta(MockData.NUMERO_CUENTA))
						.expectNext(response)
						.verifyComplete();
		
	}

}
