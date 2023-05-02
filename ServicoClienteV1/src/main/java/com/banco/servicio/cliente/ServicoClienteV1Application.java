package com.banco.servicio.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.banco.servicio.cliente.service.impl", "com.banco.servicio.cliente.repository.ClienteRepository"})
public class ServicoClienteV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServicoClienteV1Application.class, args);
	}

}
