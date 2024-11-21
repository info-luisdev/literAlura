package com.project.LiterAlura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.LiterAlura.service.AutorService;
import com.project.LiterAlura.service.LibroService;
import com.project.LiterAlura.start.Principal;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {


	@Autowired
	private AutorService autorService;
	@Autowired
	private LibroService libroService;
	
	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(autorService, libroService);
		principal.mostrarMenu();
	}

}
