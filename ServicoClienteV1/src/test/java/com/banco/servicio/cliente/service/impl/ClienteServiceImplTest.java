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
	
	@Mock
	private PersonaRepository personaRepository;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Mock
	private ClienteMapper mapper;
	
	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;
	
	
	@Test
	void consultarClientePorIdentificacionOk() {
		Mockito.when(personaRepository.findByIdentificacion(Mockito.anyString()))
				.thenReturn(Mono.just(MockData.buildPersonaEntity()));
		
		Mockito.when(clienteRepository.findByPersonaId(Mockito.anyInt()))
				.thenReturn(Mono.just(MockData.buildClienteEntity()));
		
		StepVerifier.create(clienteServiceImpl.consultarClientePorIdentificacion(MockData.CEDULA))
					.expectComplete()
					.verify();
		
	}
	
	@Test
	void consultarClientesOk() {
		Mockito.when(personaRepository.findAll())
				.thenReturn(Flux.just(MockData.buildPersonaEntity()));
		
		StepVerifier.create(clienteServiceImpl.consultarClientes())
					.expectComplete()
					.verify();
		
	}

}
