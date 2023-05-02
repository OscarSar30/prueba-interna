package com.banco.servicio.cliente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.banco.servicio.cliente.model.ActualizarCuenta;
import com.banco.servicio.cliente.model.CrearCuenta;
import com.banco.servicio.cliente.model.GetCuentaByNumeroCuenta;
import com.banco.servicio.cliente.model.GetCuentas;
import com.banco.servicio.cliente.repository.entity.CuentaEntity;
import com.banco.servicio.cliente.repository.entity.PersonaEntity;


@Mapper(componentModel = "spring")
public interface CuentaMapper {
	
	@Mapping(source = "personaEntity.nombres", target = "nombres")
	@Mapping(source = "personaEntity.identificacion", target = "identificacion")
	@Mapping(source = "cuentaEntity.numeroCuenta", target = "numeroCuenta")
	@Mapping(source = "cuentaEntity.tipoCuenta", target = "tipoCuenta")
	@Mapping(source = "cuentaEntity.saldoInicial", target = "saldoInicial")
	@Mapping(source = "cuentaEntity.estado", target = "estado")	
	GetCuentaByNumeroCuenta entitiesToGetCuenta(CuentaEntity cuentaEntity, PersonaEntity personaEntity);
	
	GetCuentas entityToGetCuenta(CuentaEntity cuentaEntity);
	
	@Mapping(source = "personaEntity.nombres", target = "nombres")
	@Mapping(source = "personaEntity.identificacion", target = "identificacion")
	@Mapping(source = "cuentaEntity.numeroCuenta", target = "numeroCuenta")
	@Mapping(source = "cuentaEntity.tipoCuenta", target = "tipoCuenta")
	@Mapping(source = "cuentaEntity.saldoInicial", target = "saldoInicial")
	@Mapping(source = "cuentaEntity.estado", target = "estado")	
	GetCuentas entitiesToGetCuentaByIdentificacion(CuentaEntity cuentaEntity, PersonaEntity personaEntity);

	CuentaEntity crearCuentaRequestToCuentaEntity(CrearCuenta request);

	@Mapping(source = "cuentaEntity.cuentaId", target = "cuentaId")
	@Mapping(source = "cuentaEntity.numeroCuenta", target = "numeroCuenta")
	@Mapping(source = "request.tipoCuenta", target = "tipoCuenta")
	@Mapping(source = "request.saldoInicial", target = "saldoInicial")
	@Mapping(source = "request.estado", target = "estado")
	@Mapping(source = "cuentaEntity.clienteId", target = "clienteId")
	CuentaEntity actualizarCuentaRequestToCuentaEntity(ActualizarCuenta request, CuentaEntity cuentaEntity);

}
