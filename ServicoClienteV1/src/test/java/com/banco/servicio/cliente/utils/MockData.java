package com.banco.servicio.cliente.utils;

import java.time.LocalDateTime;
import java.util.Date;

import com.banco.servicio.cliente.model.GetClientes;
import com.banco.servicio.cliente.model.GetCuentaByNumeroCuenta;
import com.banco.servicio.cliente.model.GetCuentas;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuenta;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuentaAndTipo;
import com.banco.servicio.cliente.model.GetPersonaAll;
import com.banco.servicio.cliente.repository.entity.ClienteModelEntity;
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
	
	public static ClienteModelEntity buildClienteEntity() {
		ClienteModelEntity clienteEntity = new ClienteModelEntity();
		clienteEntity.setPersonaId(1);
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
	
	public static GetClientes buildGetClientes() {
		return new GetClientes()
				.direccion("Guasmo Central")
				.edad(27)
				.genero("Masculino")
				.identificacion("09999999999")
				.nombres("Oscar Sarcos")
				.telefono("0912345678")
				.estado(true);
	}
	
	public static GetPersonaAll buildGetPersonaAll() {
		return new GetPersonaAll()
				.direccion("Guasmo Central")
				.edad(27)
				.genero("Masculino")
				.identificacion("09999999999")
				.nombres("Oscar Sarcos")
				.telefono("0912345678");
	}
	
	public static GetCuentaByNumeroCuenta buildGetCuentaByNumeroCuenta() {
		GetCuentaByNumeroCuenta byNumeroCuenta = new GetCuentaByNumeroCuenta();
		byNumeroCuenta.setIdentificacion("09999999999");
		byNumeroCuenta.setNombres("Oscar Sarcos");
		byNumeroCuenta.setNumeroCuenta("23456789");
		byNumeroCuenta.setSaldoInicial(0.00);
		byNumeroCuenta.setTipoCuenta("Ahorros");
		byNumeroCuenta.setEstado(true);
		return byNumeroCuenta;
	}
	
	public static GetCuentas buildGetCuentas() {
		GetCuentas cuentas = new GetCuentas();
		cuentas.setIdentificacion("09999999999");
		cuentas.setNombres("Oscar Sarcos");
		cuentas.setNumeroCuenta("23456789");
		cuentas.setSaldoInicial(0.00);
		cuentas.setTipoCuenta("Ahorros");
		cuentas.setEstado(true);
		return cuentas;
	}
	
	public static GetMovimientosByNumeroCuentaAndTipo buildGetMovimientosByNumeroCuentaAndTipo() {
		GetMovimientosByNumeroCuentaAndTipo byNumeroCuentaAndTipo = new GetMovimientosByNumeroCuentaAndTipo();
		byNumeroCuentaAndTipo.setFecha(LocalDateTime.now().toString());
		byNumeroCuentaAndTipo.setNumeroCuenta("23456789");
		byNumeroCuentaAndTipo.setSaldo(0.00);
		byNumeroCuentaAndTipo.setSaldoInicial(10000.00);
		byNumeroCuentaAndTipo.setTipoMovimiento("Retiro");
		byNumeroCuentaAndTipo.setValor(100.00);
		return byNumeroCuentaAndTipo;
	}
	
	public static GetMovimientosByNumeroCuenta buildGetMovimientosByNumeroCuenta() {
		GetMovimientosByNumeroCuenta byNumeroCuenta = new GetMovimientosByNumeroCuenta();
		byNumeroCuenta.setFecha(new Date());
		byNumeroCuenta.setMovimientoId(1);
		byNumeroCuenta.setSaldo(0.00);
		byNumeroCuenta.setSaldoInicial(10000.00);
		byNumeroCuenta.setTipoMovimiento("Retiro");
		byNumeroCuenta.setValor(100.00);
		return byNumeroCuenta;
	}

}
