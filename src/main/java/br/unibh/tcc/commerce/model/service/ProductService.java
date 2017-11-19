package br.unibh.tcc.commerce.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unibh.tcc.commerce.model.Product;
import br.unibh.tcc.commerce.model.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product save(Product product){
		return productRepository.save(product);
	}
	
	public Product findById(Long id){
		return productRepository.findOne(id);
	}
}


