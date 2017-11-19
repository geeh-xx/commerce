package br.unibh.tcc.commerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unibh.tcc.commerce.model.Cart;
import br.unibh.tcc.commerce.model.Product;
import br.unibh.tcc.commerce.model.service.CartService;
import br.unibh.tcc.commerce.model.service.ProductService;


@RestController
@RequestMapping("/api")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	
	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/cart")
	public List<Cart> getCart(){
		return cartService.getAll();
	}
	
	@PostMapping("/cart/{idCart}/{idProduct}")
	public Cart addProductCart(@PathVariable(value = "idCart") Long cartID,@PathVariable(value = "idProduct") Long productId){
		Cart cart = cartService.findById(cartID);
		
		if(cart == null)
			cart = new Cart();
	
		Product product = productService.findById(productId);
		
		if (product == null){
			product = new Product();
			productService.save(product);
		}
		
		cart.addProduct(product);
				
		return 	cartService.save(cart);
	}
}
