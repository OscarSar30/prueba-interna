package com.banco.servicio.cliente.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

import com.banco.servicio.cliente.mapper.MovimientoMapper;
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
@ContextConfiguration(classes = { MovimientoServiceImplTest.class })
class MovimientoServiceImplTest {

	@MockBean
	private PersonaRepository personaRepository;

	@MockBean
	private ClienteRepository clienteRepository;

	@MockBean
	private CuentaRepository cuentaRepository;

	@MockBean
	private MovimientoRepository movimientoRepository;

	@MockBean
	private MovimientoMapper mapper;

	@InjectMocks
	private MovimientoServiceImpl movimientoServiceImpl;

	@Test
	void consultarMovimientosPorCuentaTipoMovimientoOk() {
		Mockito.when(cuentaRepository.findByNumeroCuenta(Mockito.anyString()))
				.thenReturn(Mono.just(MockData.buildCuentaEntity()));

		Mockito.when(movimientoRepository.findByTipoMovimientoAndCuentaId(Mockito.anyString(), Mockito.anyInt()))
				.thenReturn(Flux.just(MockData.buildMovimientoEntity()));

		Mockito.when(mapper.entitiesToGetMovimientosByFilters(Mockito.any(), Mockito.any()))
				.thenReturn(MockData.buildGetMovimientosByNumeroCuentaAndTipo());

		StepVerifier
				.create(movimientoServiceImpl.consultarMovimientosPorCuentaTipoMovimiento(MockData.NUMERO_CUENTA,
						"Ahorros"))
				.consumeNextWith(resp -> Assertions.assertEquals(HttpStatus.OK, resp.getStatusCode())).expectComplete()
				.verify();

	}

	@Test
	void consultarMovimientosPorNumeroCuentaOk() {
		Mockito.when(cuentaRepository.findByNumeroCuenta(Mockito.anyString()))
				.thenReturn(Mono.just(MockData.buildCuentaEntity()));

		Mockito.when(movimientoRepository.findByCuentaId(Mockito.anyInt()))
				.thenReturn(Flux.just(MockData.buildMovimientoEntity()));

		Mockito.when(mapper.entityToGetMovimientosByNumeroCuenta(Mockito.any()))
				.thenReturn(MockData.buildGetMovimientosByNumeroCuenta());

		StepVerifier.create(movimientoServiceImpl.consultarMovimientosPorNumeroCuenta(MockData.NUMERO_CUENTA))
				.consumeNextWith(resp -> Assertions.assertEquals(HttpStatus.OK, resp.getStatusCode())).expectComplete()
				.verify();

	}

}
