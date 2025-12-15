package com.masai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;


@SpringBootApplication
public class ECommerceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceBackendApplication.class, args);
		System.out.println("Ecommerce backend running !");
	}
	
	@Bean
public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
    return new OpenAPI()
        .components(new Components().addSecuritySchemes("basicScheme",
            new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
        .info(new Info()
            .title("Shopx - E-Commerce Application REST API")
            .version(appVersion)
            .description(
                    "Secure and scalable REST API services built for a e-commerce platform.\n" +
                    "Includes modules for Customer, Seller, Product, Cart, and Order management.\n" +
                    "Session-based authentication system with 1-hour validity for both customers and sellers.\n" +
                    "CRUD operations for all entities with real-time testing via Swagger UI.\n" +
                    "Built using Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL.\n"+
					"\n \t-Created by Sameer Shaikh"+
					"\n \t-Tech stack : Code Java(Streams, JWT, MVC, JPA), Spring Boot, PostgreSQL, AWS EC2, Github Actions (CI/CD)"
            )
            );
}


}
