package com.nikonkdev.MySchoolAPP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Es una anotacion tipica de Spring la cual nos sirve para configurar de forma automatica el proyecto Spring Boot.
 */
@SpringBootApplication
public class MySchoolAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySchoolAppApplication.class, args);
	}

}
