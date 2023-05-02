/**
 * 
 */
package com.banco.servicio.cliente.repository;

import java.util.Date;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.banco.servicio.cliente.model.EstadoCuentaResponse;
import com.banco.servicio.cliente.repository.entity.MovimientoEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author osarcos
 *
 */
@Repository
public interface MovimientoRepository extends ReactiveCrudRepository<MovimientoEntity, Integer> {

	Flux<MovimientoEntity> findByTipoMovimientoAndCuentaId(String tipoMovimiento, Integer cuentaId);
	
	Flux<MovimientoEntity> findByCuentaId(Integer cuentaId);

	@Query("SELECT * FROM MOVIMIENTOS M WHERE M.CUENTA_ID = :ID AND M.FECHA \\:\\:DATE = :FECHA ORDER BY M.MOVIMIENTO_ID DESC LIMIT 1")
	Mono<MovimientoEntity> findByCuentaIdAndFecha(Integer cuentaId, Date fecha);
	
	@Query ("SELECT SUM(M.VALOR) FROM MOVIMIENTOS M INNER JOIN CUENTAS C ON M.CUENTA_ID_CUENTA = C.ID_CUENTA WHERE M.FECHA \\:\\:DATE = :FECHA AND M.TIPO_MOVIMIENTO = :TIPO AND C.NUMERO_CUENTA = :NUMEROCUENTA")
	Mono<String> findValorByFechaAndTipoAndNumeroCuenta (Date fecha, String tipo, String numeroCuenta);
	
	@Query ("SELECT M.FECHA, P.NOMBRES AS CLIENTE, C.NUMERO_CUENTA, C.TIPO_CUENTA AS TIPO, M.SALDO_INICIAL, M.VALOR AS MOVIMIENTO, M.SALDO AS SALDO_DISPONIBLE, 'true' ESTADO FROM MOVIMIENTOS M "
			+ "INNER JOIN CUENTAS C ON M.CUENTA_ID = C.CUENTA_ID INNER JOIN CLIENTES C2 ON C2.CLIENTE_ID = C.CLIENTE_ID INNER JOIN PERSONA P ON P.PERSONA_ID = C2.PERSONA_ID "
			+ "WHERE P.IDENTIFICACION = :IDENTIFICACION  AND M.FECHA \\:\\: DATE BETWEEN :FECHADESDE AND :FECHAHASTA \\:\\:DATE ORDER BY M.FECHA DESC")
	Flux<EstadoCuentaResponse> findEstadoCuentaByFechas(String identificacion, Date fechaDesde, Date fechaHasta);

}
