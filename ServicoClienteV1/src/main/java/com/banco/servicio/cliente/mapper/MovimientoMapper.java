package com.banco.servicio.cliente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.banco.servicio.cliente.model.CrearMovimiento;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuenta;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuentaAndTipo;
import com.banco.servicio.cliente.repository.entity.CuentaEntity;
import com.banco.servicio.cliente.repository.entity.MovimientoEntity;


@Mapper(componentModel = "spring")
public interface MovimientoMapper {
	
	@Mapping(source = "cuentaEntity.numeroCuenta", target = "numeroCuenta")
	@Mapping(source = "movimientoEntity.fecha", target = "fecha")
	@Mapping(source = "movimientoEntity.tipoMovimiento", target = "tipoMovimiento")
	@Mapping(source = "movimientoEntity.valor", target = "valor")	
	@Mapping(source = "movimientoEntity.saldo", target = "saldo")	
	@Mapping(source = "movimientoEntity.saldoInicial", target = "saldoInicial")	
	GetMovimientosByNumeroCuentaAndTipo entitiesToGetMovimientosByFilters(CuentaEntity cuentaEntity, MovimientoEntity movimientoEntity);
	
	GetMovimientosByNumeroCuenta entityToGetMovimientosByNumeroCuenta(MovimientoEntity movimientoEntity);
	
	MovimientoEntity crearMovimientoRequestToEnity(CrearMovimiento request);

}
