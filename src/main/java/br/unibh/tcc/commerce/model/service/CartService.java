package br.unibh.tcc.commerce.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unibh.tcc.commerce.model.Cart;
import br.unibh.tcc.commerce.model.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public Cart save(Cart cart){
		return cartRepository.save(cart);
	}
	
	public List<Cart> getAll(){
		return cartRepository.findAll();
	}
	
	public Cart findById(Long id){
		return cartRepository.findOne(id);
	}

	
}
