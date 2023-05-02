package com.banco.servicio.cliente.model;

import java.util.Objects;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Modelo Canónico de Cuenta
 */
@Schema(description = "Modelo Canónico de Cuenta")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")

public class ActualizarCuenta {
	
	@JsonProperty("numeroCuenta")
	@Pattern(regexp = "[0-9]*")
	private String numeroCuenta = null;

	@JsonProperty("tipoCuenta")
	private String tipoCuenta = null;

	@JsonProperty("saldoInicial")
	@DecimalMin(value = "0.00")
	private Double saldoInicial = null;

	@JsonProperty("estado")
	private Boolean estado = null;
	

	/**
	 * Get numeroCuenta
	 * 
	 * @return numeroCuenta
	 **/
	@Schema(description = "")

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public ActualizarCuenta tipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
		return this;
	}

	/**
	 * Get tipoCuenta
	 * 
	 * @return tipoCuenta
	 **/
	@Schema(description = "")

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public ActualizarCuenta saldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
		return this;
	}

	/**
	 * Get saldoInicial
	 * 
	 * @return saldoInicial
	 **/
	@Schema(description = "")

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public ActualizarCuenta estado(Boolean estado) {
		this.estado = estado;
		return this;
	}

	/**
	 * Get estado
	 * 
	 * @return estado
	 **/
	@Schema(description = "")

	public Boolean isEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ActualizarCuenta cuentaDTO = (ActualizarCuenta) o;
		return Objects.equals(this.numeroCuenta, cuentaDTO.numeroCuenta)
				&& Objects.equals(this.tipoCuenta, cuentaDTO.tipoCuenta)
				&& Objects.equals(this.saldoInicial, cuentaDTO.saldoInicial)
				&& Objects.equals(this.estado, cuentaDTO.estado);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroCuenta, tipoCuenta, saldoInicial, estado);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CuentaDTO {\n");

		sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
		sb.append("    tipoCuenta: ").append(toIndentedString(tipoCuenta)).append("\n");
		sb.append("    saldoInicial: ").append(toIndentedString(saldoInicial)).append("\n");
		sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
