/**
 * 
 */
package com.banco.servicio.cliente.model;

import java.time.LocalDateTime;

/**
 * @author osarcos
 *
 */
public class EstadoCuentaResponse {

	private LocalDateTime fecha;
	private String cliente;
	private String numeroCuenta;
	private String tipo;
	private Double saldoInicial;
	private boolean estado;
	private Double movimiento;
	private Double saldoDisponible;

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Double getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Double movimiento) {
		this.movimiento = movimiento;
	}

	public Double getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(Double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

}
