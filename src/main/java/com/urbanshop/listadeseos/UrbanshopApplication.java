package com.urbanshop.listadeseos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients; // 1. Importa esto

@SpringBootApplication
@EnableFeignClients
public class UrbanshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(UrbanshopApplication.class, args);
	}
}