/**
 * 
 */
package com.banco.servicio.cliente.repository.entity;

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
@Table("cuentas")
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaEntity {

	@Id
	@Column("cuenta_id")
	private Integer cuentaId;
	
	@Column("numero_cuenta")
	private String numeroCuenta;

	@Column("tipo_cuenta")
	private String tipoCuenta;

	@Column("saldo_inicial")
	private double saldoInicial;

	@Column("estado")
	private boolean estado;
	
	@Column("cliente_id")
	private Integer clienteId;

}
