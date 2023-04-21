/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package ec.com.servicioentidad.banco.controller.contract;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.com.servicioentidad.banco.dto.EstadoCuentaDTO;
import ec.com.servicioentidad.banco.dto.RespuestaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")
@Validated
public interface IReporteController {


    /**
     * Método GET para consultar estado de cuenta de un cliente
     * @param identificacion
     * @return
     */
    @Operation(summary = "Consultar estado de cuenta de un cliente", description = "Consultar estado de cuenta de un cliente", tags={ "Reporte" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EstadoCuentaDTO.class)))),
        
        @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RespuestaDTO.class))) })
    @RequestMapping(value = "/reportes/{identificacion}/{fechaDesde}/{fechaHasta}",
        produces = "application/json; charset=UTF-8", 
        method = RequestMethod.GET)
    ResponseEntity<?> consultarEstadoCuenta(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("identificacion") String identificacion,
    		@PathVariable (name = "fechaDesde", required = true)@DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde, @PathVariable (name = "fechaHasta", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta);

}
