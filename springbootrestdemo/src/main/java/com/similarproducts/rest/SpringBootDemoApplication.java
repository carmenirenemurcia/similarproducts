package com.similarproducts.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.similarproducts.rest.controller.SimilarProductsController;
@ComponentScan(basePackageClasses=SimilarProductsController.class)
@SpringBootApplication 
public class SpringBootDemoApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
