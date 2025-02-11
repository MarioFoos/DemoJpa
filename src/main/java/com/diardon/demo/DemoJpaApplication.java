package com.diardon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner
{
    @Autowired
    private ProductoService productoService;    
    
	public static void main(String[] args)
	{
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception
	{
        productoService.ejecutarEjemplo();
    }
}

