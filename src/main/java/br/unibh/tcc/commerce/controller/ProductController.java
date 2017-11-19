package br.unibh.tcc.commerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unibh.tcc.commerce.model.Product;
import br.unibh.tcc.commerce.model.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	private Product getProducts(){
		return productService.findAll();
	}
	
	@PostMapping("/product")
	private Product saveProduct(@RequestBody Product product){
		return productService.save(product);
	}
	
}
