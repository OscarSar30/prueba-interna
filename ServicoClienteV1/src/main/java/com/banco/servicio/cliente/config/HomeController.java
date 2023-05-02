package com.banco.servicio.cliente.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home redirection to OpenAPI api documentation
 */
@Controller
public class HomeController {
	@GetMapping(value = "/")
	public String index() {
		return "redirect:swagger-ui.html";
	}
}
