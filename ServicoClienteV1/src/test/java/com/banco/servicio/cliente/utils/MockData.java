package com.banco.servicio.cliente.utils;

import java.time.LocalDateTime;

import com.banco.servicio.cliente.repository.entity.ClienteEntity;
import com.banco.servicio.cliente.repository.entity.CuentaEntity;
import com.banco.servicio.cliente.repository.entity.MovimientoEntity;
import com.banco.servicio.cliente.repository.entity.PersonaEntity;

public class MockData {
	
	private MockData() {}
	
	public static final String CEDULA = "09999999999";
	public static final String NUMERO_CUENTA = "23456789";
	
	public static PersonaEntity buildPersonaEntity() {
		return new PersonaEntity().builder()
				.direccion("Guasmo Central")
				.edad(27)
				.genero("Masculino")
				.identificacion("09999999999")
				.nombres("Oscar Sarcos")
				.personaId(1)
				.telefono("0912345678")
				.build();
	}
	
	public static ClienteEntity buildClienteEntity() {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setDireccion("Guasmo Central");
		clienteEntity.setEdad(27);
		clienteEntity.setGenero("Masculino");
		clienteEntity.setIdentificacion("09999999999");
		clienteEntity.setNombres("Oscar Sarcos");
		clienteEntity.setPersonaId(1);
		clienteEntity.setTelefono("0912345678");
		clienteEntity.setClienteId(1);
		clienteEntity.setContrasenia("12345678");
		clienteEntity.setEstado(true);
		return clienteEntity;
	}
	
	public static CuentaEntity buildCuentaEntity() {
		return new CuentaEntity().builder()
				.clienteId(1)
				.cuentaId(1)
				.estado(true)
				.numeroCuenta("23456789")
				.saldoInicial(0)
				.tipoCuenta("Ahorros")
				.build();
	}
	
	public static MovimientoEntity buildMovimientoEntity() {
		return new MovimientoEntity().builder()
				.cuentaId(1)
				.fecha(LocalDateTime.now())
				.movimientoId(1)
				.saldo(0)
				.saldoInicial(1000.00)
				.tipoMovimiento("Deposito")
				.valor(1000)
				.build();
	}

}
