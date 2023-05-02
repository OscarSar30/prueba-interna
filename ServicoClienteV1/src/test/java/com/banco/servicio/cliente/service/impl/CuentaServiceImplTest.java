package com.banco.servicio.cliente.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.banco.servicio.cliente.mapper.CuentaMapper;
import com.banco.servicio.cliente.repository.ClienteRepository;
import com.banco.servicio.cliente.repository.CuentaRepository;
import com.banco.servicio.cliente.repository.PersonaRepository;
import com.banco.servicio.cliente.utils.MockData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {CuentaServiceImpl.class})
class CuentaServiceImplTest {
	
	@Mock
	private PersonaRepository personaRepository;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Mock
	private CuentaRepository cuentaRepository;
	
	@Mock
	private CuentaMapper mapper;
	
	@InjectMocks
	private CuentaServiceImpl cuentaServiceImpl;
	
	
	@Test
	void consultarCuentaPorNumeroCuentaOk() {
		Integer personaId = 1;
		Mockito.when(cuentaRepository.findByNumeroCuenta(Mockito.anyString()))
				.thenReturn(Mono.just(MockData.buildCuentaEntity()));
		
		Mockito.when(clienteRepository.findPersonaIdByClienteId(Mockito.anyInt()))
				.thenReturn(Mono.just(personaId));
		
		StepVerifier.create(cuentaServiceImpl.consultarCuentaPorNumeroCuenta(MockData.NUMERO_CUENTA))
					.expectComplete()
					.verify();
		
	}
	
	@Test
	void consultarCuentasOk() {
		Mockito.when(cuentaRepository.findAll())
				.thenReturn(Flux.just(MockData.buildCuentaEntity()));
		
		StepVerifier.create(cuentaServiceImpl.consultarCuentas())
					.expectComplete()
					.verify();
		
	}
	
	@Test
	void consultarCuentasPorIdentificacionOk() {
		Integer personaId = 1;
		Mockito.when(personaRepository.findByIdentificacion(Mockito.anyString()))
				.thenReturn(Mono.just(MockData.buildPersonaEntity()));
		
		Mockito.when(clienteRepository.findClienteIdByPersonaId(Mockito.anyInt()))
				.thenReturn(Mono.just(personaId));
		
		Mockito.when(cuentaRepository.findByClienteId(Mockito.anyInt()))
				.thenReturn(Flux.just(MockData.buildCuentaEntity()));
		
		StepVerifier.create(cuentaServiceImpl.consultarCuentasPorIdentificacion(MockData.CEDULA))
					.expectComplete()
					.verify();
		
	}

}
