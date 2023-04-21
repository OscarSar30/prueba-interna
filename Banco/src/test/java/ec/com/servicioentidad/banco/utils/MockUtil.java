package ec.com.servicioentidad.banco.utils;

import java.util.UUID;

import ec.com.servicioentidad.banco.dto.ClienteDTO;

public class MockUtil {
	
	public static ClienteDTO buildClienteDto() {
		String superSecretId = "f000aa01-0451-4000-b000-000000000000";
		return new ClienteDTO()
				.clienteId(UUID.fromString(superSecretId))
				.contrasenia("")
				.estado(Boolean.TRUE);
	}

}
