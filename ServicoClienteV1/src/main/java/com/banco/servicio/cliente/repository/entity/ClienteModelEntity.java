/**
 * 
 */
package com.banco.servicio.cliente.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author osarcos
 *
 */
@Table("clientes")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModelEntity {

	@Id
	@Column("cliente_id")
	private Integer clienteId;

	@Column("contrasenia")
	private String contrasenia;

	@Column("estado")
	private boolean estado;
	
	@Column("persona_id")
	private Integer personaId;

}
