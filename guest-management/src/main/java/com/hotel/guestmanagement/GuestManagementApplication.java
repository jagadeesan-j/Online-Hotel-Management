package com.hotel.guestmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableSwagger2
public class GuestManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestManagementApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/guest/**"))
				.apis(RequestHandlerSelectors.basePackage("com.hotel"))
				.build()
				.apiInfo(apiInfo());
	}

	public ApiInfo apiInfo() {
		return new ApiInfo(
				"Guest Management API Documentation",
				"API endpoints for the Guest Management Microservice.",
				"1.0",
				"Free to use.",
				new Contact("Hotel Management",
						"http://hotel.com",
						"contact@mail.com"),
				"API License",
				"http://hotel.com",
				Collections.emptyList());
	}
}
