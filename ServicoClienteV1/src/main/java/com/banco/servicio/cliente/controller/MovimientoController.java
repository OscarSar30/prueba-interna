/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.banco.servicio.cliente.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banco.servicio.cliente.model.CrearMovimiento;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuenta;
import com.banco.servicio.cliente.model.GetMovimientosByNumeroCuentaAndTipo;
import com.banco.servicio.cliente.model.RespuestaDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")
@Validated
public interface MovimientoController {


    /**
     * GET /movimientos/numero/{numeroCuenta} : Consultar movimientos por tipo de movimiento
     * Consultar movimientos por tipo de movimiento
     *
     * @param numeroCuenta  (required)
     * @return OK (status code 200)
     *         or No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @Operation(summary = "Consultar movimientos por número de cuenta", description = "Consultar movimientos por número de cuenta", tags={ "Movimientos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GetMovimientosByNumeroCuenta.class)))),
        
        @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))) })
    @RequestMapping(value = "/movimientos/numero/{numeroCuenta}",
        produces = "application/json; charset=UTF-8", 
        method = RequestMethod.GET)
    Mono<ResponseEntity<Flux<GetMovimientosByNumeroCuenta>>> consultarMovimientosPorNumeroCuenta(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("numeroCuenta") String numeroCuenta);

    
    /**
     * GET /movimientos/cuenta/tipo/{numeroCuenta}/{tipoMovimiento} : Consultar movimientos por tipo de movimiento
     * Consultar movimientos por tipo de movimiento
     *
     * @param numeroCuenta  (required)
     * @param tipoMovimiento  (required)
     * @return OK (status code 200)
     *         or No Content (status code 204)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @Operation(summary = "Consultar movimientos por tipo de movimiento", description = "Consultar movimientos por tipo de movimiento", tags={ "Movimientos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GetMovimientosByNumeroCuentaAndTipo.class)))),
        
        @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))) })
    @RequestMapping(value = "/movimientos/cuenta/tipo/{numeroCuenta}/{tipoMovimiento}",
        produces = "application/json; charset=UTF-8", 
        method = RequestMethod.GET)
    Mono<ResponseEntity<Flux<GetMovimientosByNumeroCuentaAndTipo>>> consultarMovimientosPorCuentaTipoMovimiento(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("numeroCuenta") String numeroCuenta, @PathVariable("tipoMovimiento") String tipoMovimiento);

    
    /**
     * POST /movimientos : Crear nuevo movimiento
     * Crear nuevo movimiento
     *
     * @param body  (required)
     * @return Created (status code 201)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @Operation(summary = "Crear nuevo movimiento", description = "Crear nuevo movimiento", tags={ "Movimientos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "OK", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))) })
    @RequestMapping(value = "/movimientos",
        produces = "application/json; charset=UTF-8", 
        consumes = "application/json; charset=UTF-8",
        method = RequestMethod.POST)
    Mono<ResponseEntity<Void>> crearMovimiento(@Parameter(in = ParameterIn.DEFAULT, description = "Movimiento", required=true, schema=@Schema()) @RequestBody Mono<CrearMovimiento> body);

}
