package com.similarproducts.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.similarproducts.rest.model.Product;

@RestController
@RequestMapping(path = "/product")
public class SimilarProductsController {
	@GetMapping("/{productId}/similar")

	public ResponseEntity<List<Product>> getSimilarProducstById(@PathVariable("productId") String productId) {
		final Logger log = LoggerFactory.getLogger(SimilarProductsController.class);
		List<Product> productList = new ArrayList<Product>();

		try {

			RestTemplate restTemplate = new RestTemplate();
			// TODO: move endpoints to properties
			Integer similarProductList[] = restTemplate
					.getForObject("http://localhost:3001/product/{productId}/similarids", Integer[].class, productId);
			for (int i = 0; i < similarProductList.length; i++) {
				Product product = restTemplate.getForObject("http://localhost:3001/product/{productId}", Product.class,
						similarProductList[i].toString());
				productList.add(product);
			}
			return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);

		} catch (Exception e) {

			log.error("System Error:", e.getMessage());

			return new ResponseEntity<List<Product>>(productList, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
