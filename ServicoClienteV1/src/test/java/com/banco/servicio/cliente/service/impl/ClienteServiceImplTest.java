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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.banco.servicio.cliente.mapper.ClienteMapper;
import com.banco.servicio.cliente.repository.ClienteRepository;
import com.banco.servicio.cliente.repository.PersonaRepository;
import com.banco.servicio.cliente.utils.MockData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {ClienteServiceImpl.class})
class ClienteServiceImplTest {
	
	@MockBean
	private PersonaRepository personaRepository;
	
	@MockBean
	private ClienteRepository clienteRepository;
	
	@MockBean
	private ClienteMapper mapper;
	
	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;
	
	
	@Test
	void consultarClientePorIdentificacionOk() {
		Mockito.when(personaRepository.findByIdentificacion(Mockito.anyString()))
				.thenReturn(Mono.just(MockData.buildPersonaEntity()));
		
		Mockito.when(clienteRepository.findByPersonaId(Mockito.anyInt()))
				.thenReturn(Mono.just(MockData.buildClienteEntity()));
		
		Mockito.when(mapper.entityToGetClientes(Mockito.any(), Mockito.any()))
				.thenReturn(MockData.buildGetClientes());
		
		StepVerifier.create(clienteServiceImpl.consultarClientePorIdentificacion(MockData.CEDULA))
					.expectNext(ResponseEntity.status(HttpStatus.OK).body(MockData.buildGetClientes()))
					.verifyComplete();
		
	}
	
	@Test
	void consultarClientesOk() {
		Mockito.when(personaRepository.findAll())
				.thenReturn(Flux.just(MockData.buildPersonaEntity()));
		
		Mockito.when(mapper.entityToGetClientesAll(Mockito.any()))
				.thenReturn(MockData.buildGetPersonaAll());
				
		StepVerifier.create(clienteServiceImpl.consultarClientes())
					.consumeNextWith(resp ->
							Assertions.assertEquals(HttpStatus.OK, resp.getStatusCode())
					).expectComplete()
					.verify();
		
	}

}
