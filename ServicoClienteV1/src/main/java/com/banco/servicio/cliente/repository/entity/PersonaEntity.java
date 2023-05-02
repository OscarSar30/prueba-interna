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
@Table("persona")
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {
	
	@Id
	@Column("persona_id")
	private Integer personaId;
	
	@Column("nombres")
	private String nombres;

	@Column("genero")
	private String genero;

	@Column("edad")
	private Integer edad;

	@Column("identificacion")
	private String identificacion;

	@Column("direccion")
	private String direccion;

	@Column("telefono")
	private String telefono;

}
