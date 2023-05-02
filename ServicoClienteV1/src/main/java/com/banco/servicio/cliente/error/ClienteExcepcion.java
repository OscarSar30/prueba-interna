package com.banco.servicio.cliente.error;

import com.banco.servicio.cliente.model.RespuestaDTO;

/**
 * @author osarcos
 *
 */
public class ClienteExcepcion {
	
	private ClienteExcepcion() {
	}
	public static final String BUSQUEDA_SIN_EXITO = "Recurso no encontrado";
	public static final String CEDULA_EXISTENTE = "Estimado cliente, el número de identificación ya se encuentra registrado.";
	public static final String SALDO_CERO = "Saldo no disponible";
	public static final String CUPO_MAXIMO = "Cupo diario Excedido";
	
	public static final AplicationException NOT_FOUND_DATA = new AplicationException(
			new RespuestaDTO().codigoRespuesta("204")
			.descripcion(BUSQUEDA_SIN_EXITO)
			);
	
	public static final AplicationException ERROR_CEDULA_EXISTE = new AplicationException(
			new RespuestaDTO().codigoRespuesta("500")
			.descripcion(CEDULA_EXISTENTE)
			);
	
	public static final AplicationException ERROR_SALDO_EN_CERO = new AplicationException(
			new RespuestaDTO().codigoRespuesta("500")
			.descripcion(SALDO_CERO)
			);
	
	public static final AplicationException ERROR_MAXIMO_CUPO = new AplicationException(
			new RespuestaDTO().codigoRespuesta("500")
			.descripcion(CUPO_MAXIMO)
			);


}
