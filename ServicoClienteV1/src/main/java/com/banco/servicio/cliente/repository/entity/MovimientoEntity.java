/**
 * 
 */
package com.banco.servicio.cliente.repository.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author osarcos
 *
 */
@Table("movimientos")
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column("movimiento_id")
	private Integer movimientoId;
	
	@Column("fecha")
	private LocalDateTime fecha;

	@Column("tipo_movimiento")
	private String tipoMovimiento;

	@Column("valor")
	private double valor;

	@Column("saldo")
	private double saldo;
	
	@Column("saldo_inicial")
	private double saldoInicial;
	
	@Column("cuenta_id")
	private Integer cuentaId;

}
