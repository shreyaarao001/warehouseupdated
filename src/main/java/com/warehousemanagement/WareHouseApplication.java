package com.warehousemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan(basePackages = {"com.warehousemanagement"})
@EntityScan(basePackages = {"com.warehousemanagement"})
@EnableJpaRepositories(basePackages = {"com.warehousemanagement"})
@SpringBootApplication
public class WareHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WareHouseApplication.class, args);
	}

}