package com.banco.servicio.cliente.error;

import com.banco.servicio.cliente.model.RespuestaDTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AplicationException extends RuntimeException {
	
	private final RespuestaDTO dto;

}
