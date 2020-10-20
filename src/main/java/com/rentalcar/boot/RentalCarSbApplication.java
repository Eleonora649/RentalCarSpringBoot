package com.rentalcar.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.rentalcar.boot"})
public class RentalCarSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalCarSbApplication.class, args);
	}
}
