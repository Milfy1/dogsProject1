package com.udacity.bootstrap;
//zeadoo
//Mohammed-Aldrees
//Tareq-Assiri
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library APIS" , version = "1.0", description = "Library Management Apis."))
public class BootstrapApplication {

	public static void main(String[] args) {
	 SpringApplication.run(BootstrapApplication.class, args);
	}
}


