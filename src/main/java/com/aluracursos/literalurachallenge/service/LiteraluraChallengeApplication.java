package com.aluracursos.literalurachallenge.service;

import com.aluracursos.literalurachallenge.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.aluracursos.literalurachallenge")
@EntityScan(basePackages = "com.aluracursos.literalurachallenge.model") // Escanea el paquete donde estan las entidades
@EnableJpaRepositories(basePackages = "com.aluracursos.literalurachallenge.repository")


public class LiteraluraChallengeApplication implements CommandLineRunner {

	private final Principal principal;

	@Autowired
	public LiteraluraChallengeApplication(Principal principal) {

		this.principal = principal;

	}


	public static void main(String[] args) {

		SpringApplication.run(LiteraluraChallengeApplication.class, args);

	}

	//Constructor clase Principal
	@Override
	public void run(String... args) throws Exception {

		principal.muestraElMenu();

	}

}
