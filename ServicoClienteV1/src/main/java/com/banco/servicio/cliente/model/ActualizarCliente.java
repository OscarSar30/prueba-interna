package com.banco.servicio.cliente.model;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Modelo Canónico de Cliente
 */
@ApiModel(description = "Modelo Canónico de Cliente")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-29T14:35:28.176321-05:00[America/Guayaquil]")

public class ActualizarCliente  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("clienteId")
  private Integer clienteId;
  
  @JsonProperty("nombres")
  private String nombres;

  @JsonProperty("genero")
  private String genero;

  @JsonProperty("edad")
  private Integer edad;

  @JsonProperty("identificacion")
  private String identificacion;

  @JsonProperty("direccion")
  private String direccion;

  @JsonProperty("telefono")
  private String telefono;
  
  @JsonProperty("contrasenia")
  private String contrasenia;

  @JsonProperty("estado")
  private Boolean estado;
  
  public ActualizarCliente clienteId(Integer clienteId) {
    this.clienteId = clienteId;
    return this;
  }

  /**
   * Get clienteId
   * @return clienteId
  */
  @ApiModelProperty(value = "")


  public Integer getClienteId() {
    return clienteId;
  }

  public void setClienteId(Integer clienteId) {
    this.clienteId = clienteId;
  }

  public ActualizarCliente nombres(String nombres) {
    this.nombres = nombres;
    return this;
  }

  /**
   * Get nombres
   * @return nombres
  */
  @ApiModelProperty(value = "")


  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public ActualizarCliente genero(String genero) {
    this.genero = genero;
    return this;
  }

  /**
   * Get genero
   * @return genero
  */
  @ApiModelProperty(value = "")


  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public ActualizarCliente edad(Integer edad) {
    this.edad = edad;
    return this;
  }

  /**
   * Get edad
   * minimum: 2
   * maximum: 3
   * @return edad
  */
  @ApiModelProperty(value = "")

@Min(2) @Max(3) 
  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public ActualizarCliente identificacion(String identificacion) {
    this.identificacion = identificacion;
    return this;
  }

  /**
   * Get identificacion
   * @return identificacion
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Size(min=10,max=13) 
  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public ActualizarCliente direccion(String direccion) {
    this.direccion = direccion;
    return this;
  }

  /**
   * Get direccion
   * @return direccion
  */
  @ApiModelProperty(value = "")


  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public ActualizarCliente telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * Get telefono
   * @return telefono
  */
  @ApiModelProperty(value = "")


  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  public ActualizarCliente contrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
    return this;
  }

  /**
   * Get contrasenia
   * @return contrasenia
  */
  @ApiModelProperty(value = "")


  public String getContrasenia() {
    return contrasenia;
  }

  public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
  }

  public ActualizarCliente estado(Boolean estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
  */
  @ApiModelProperty(value = "")


  public Boolean getEstado() {
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
    ActualizarCliente clienteDTO = (ActualizarCliente) o;
    return Objects.equals(this.nombres, clienteDTO.nombres) &&
        Objects.equals(this.genero, clienteDTO.genero) &&
        Objects.equals(this.edad, clienteDTO.edad) &&
        Objects.equals(this.identificacion, clienteDTO.identificacion) &&
        Objects.equals(this.direccion, clienteDTO.direccion) &&
        Objects.equals(this.telefono, clienteDTO.telefono) &&
        Objects.equals(this.estado, clienteDTO.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombres, genero, edad, identificacion, direccion, telefono, estado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClienteDTO {\n");
    
    sb.append("    nombres: ").append(toIndentedString(nombres)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    edad: ").append(toIndentedString(edad)).append("\n");
    sb.append("    identificacion: ").append(toIndentedString(identificacion)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
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

