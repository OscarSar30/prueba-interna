package com.banco.servicio.cliente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.banco.servicio.cliente.model.GetClientes;
import com.banco.servicio.cliente.model.GetPersonaAll;
import com.banco.servicio.cliente.model.CrearCliente;
import com.banco.servicio.cliente.model.ActualizarCliente;
import com.banco.servicio.cliente.repository.entity.ClienteEntity;
import com.banco.servicio.cliente.repository.entity.PersonaEntity;


@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	@Mapping(source = "personaEntity.nombres", target = "nombres")
	@Mapping(source = "personaEntity.genero", target = "genero")
	@Mapping(source = "personaEntity.edad", target = "edad")
	@Mapping(source = "personaEntity.direccion", target = "direccion")
	@Mapping(source = "personaEntity.telefono", target = "telefono")	
	@Mapping(source = "personaEntity.identificacion", target = "identificacion")
	@Mapping(source = "clienteEntity.estado", target = "estado")
	GetClientes entityToGetClientes(PersonaEntity personaEntity, ClienteEntity clienteEntity);
	
	@Mapping(source = "entity.nombres", target = "nombres")
	@Mapping(source = "entity.genero", target = "genero")
	@Mapping(source = "entity.edad", target = "edad")
	@Mapping(source = "entity.direccion", target = "direccion")
	@Mapping(source = "entity.telefono", target = "telefono")	
	@Mapping(source = "entity.identificacion", target = "identificacion")
	GetPersonaAll entityToGetClientesAll(PersonaEntity entity);
	
	@Mapping(source = "request.nombres", target = "nombres")
	@Mapping(source = "request.genero", target = "genero")
	@Mapping(source = "request.edad", target = "edad")
	@Mapping(source = "request.direccion", target = "direccion")
	@Mapping(source = "request.telefono", target = "telefono")	
	@Mapping(source = "request.identificacion", target = "identificacion")
	PersonaEntity postRequestToPersonaEntity (CrearCliente request);
	
	@Mapping(source = "entity.personaId", target = "personaId")
	@Mapping(source = "request.nombres", target = "nombres")
	@Mapping(source = "request.genero", target = "genero")
	@Mapping(source = "request.edad", target = "edad")
	@Mapping(source = "request.direccion", target = "direccion")
	@Mapping(source = "request.telefono", target = "telefono")	
	@Mapping(source = "request.identificacion", target = "identificacion")
	PersonaEntity putRequestToPersonaEntity (ActualizarCliente request, PersonaEntity entity);

}
