package com.itau.estagiaria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstagiariaBackendApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(EstagiariaBackendApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Iniciando Api de Cadastro!");
		SpringApplication.run(EstagiariaBackendApplication.class, args);
		LOGGER.info("Api de Cadastro iniciado com sucesso!");


	}

}
