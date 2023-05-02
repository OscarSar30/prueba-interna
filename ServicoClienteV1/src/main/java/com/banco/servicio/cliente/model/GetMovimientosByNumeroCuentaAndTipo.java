package com.banco.servicio.cliente.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Modelo Canónico de Movimiento
 */
@Schema(description = "Modelo Canónico de Movimiento")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")

public class GetMovimientosByNumeroCuentaAndTipo {
	
	@JsonProperty("numeroCuenta")
	private String numeroCuenta = null;
	
	@JsonProperty("fecha")
	private String fecha = null;

	@JsonProperty("tipoMovimiento")
	private String tipoMovimiento = null;

	@JsonProperty("valor")
	@DecimalMin(value = "0.00")
	private Double valor = null;

	@JsonProperty("saldo")
	@DecimalMin(value = "0.00")
	private Double saldo = null;
	
	private Double saldoInicial;

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public GetMovimientosByNumeroCuentaAndTipo fecha(String fecha) {
		this.fecha = fecha;
		return this;
	}

	/**
	 * Get fecha
	 * 
	 * @return fecha
	 **/
	@Schema(description = "")

	@Valid
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public GetMovimientosByNumeroCuentaAndTipo tipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
		return this;
	}

	/**
	 * Get tipoMovimiento
	 * 
	 * @return tipoMovimiento
	 **/
	@Schema(description = "")

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public GetMovimientosByNumeroCuentaAndTipo valor(Double valor) {
		this.valor = valor;
		return this;
	}

	/**
	 * Get valor
	 * 
	 * @return valor
	 **/
	@Schema(description = "")

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public GetMovimientosByNumeroCuentaAndTipo saldo(Double saldo) {
		this.saldo = saldo;
		return this;
	}

	/**
	 * Get saldo
	 * 
	 * @return saldo
	 **/
	@Schema(description = "")

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GetMovimientosByNumeroCuentaAndTipo movimientosDTO = (GetMovimientosByNumeroCuentaAndTipo) o;
		return Objects.equals(this.fecha, movimientosDTO.fecha)
				&& Objects.equals(this.tipoMovimiento, movimientosDTO.tipoMovimiento)
				&& Objects.equals(this.valor, movimientosDTO.valor) && Objects.equals(this.saldo, movimientosDTO.saldo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, tipoMovimiento, valor, saldo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MovimientosDTO {\n");

		sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
		sb.append("    tipoMovimiento: ").append(toIndentedString(tipoMovimiento)).append("\n");
		sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
		sb.append("    saldo: ").append(toIndentedString(saldo)).append("\n");
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
