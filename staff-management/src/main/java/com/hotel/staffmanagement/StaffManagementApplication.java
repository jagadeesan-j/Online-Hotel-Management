package com.hotel.staffmanagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableEurekaClient
//@EnableSwagger2
public class StaffManagementApplication  {


	public static void main(String[] args) {
		SpringApplication.run(StaffManagementApplication.class, args);
	}



}
