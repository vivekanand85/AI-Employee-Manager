package com.javaProject.aipowered;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//import com.javaProject.controller.EmployeeController;

@SpringBootApplication
//@ComponentScan(basePackages = "com.javaProject")
public class AipoweredApplication {

	public static void main(String[] args) {
		SpringApplication.run(AipoweredApplication.class, args);
		System.out.println("application about to start");
//		System.out.println(EmployeeController.class);
	}

}
