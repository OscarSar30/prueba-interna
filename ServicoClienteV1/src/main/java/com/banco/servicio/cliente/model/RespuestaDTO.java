package com.banco.servicio.cliente.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Modelo Canónico de Respuesta
 */
@ApiModel(description = "Modelo Canónico de Respuesta")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-29T14:35:28.176321-05:00[America/Guayaquil]")

public class RespuestaDTO  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("codigoRespuesta")
  private String codigoRespuesta;

  @JsonProperty("descripcion")
  private String descripcion;

  public RespuestaDTO codigoRespuesta(String codigoRespuesta) {
    this.codigoRespuesta = codigoRespuesta;
    return this;
  }

  /**
   * Get codigoRespuesta
   * @return codigoRespuesta
  */
  @ApiModelProperty(value = "")


  public String getCodigoRespuesta() {
    return codigoRespuesta;
  }

  public void setCodigoRespuesta(String codigoRespuesta) {
    this.codigoRespuesta = codigoRespuesta;
  }

  public RespuestaDTO descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
  */
  @ApiModelProperty(value = "")


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespuestaDTO respuestaDTO = (RespuestaDTO) o;
    return Objects.equals(this.codigoRespuesta, respuestaDTO.codigoRespuesta) &&
        Objects.equals(this.descripcion, respuestaDTO.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigoRespuesta, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespuestaDTO {\n");
    
    sb.append("    codigoRespuesta: ").append(toIndentedString(codigoRespuesta)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
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

