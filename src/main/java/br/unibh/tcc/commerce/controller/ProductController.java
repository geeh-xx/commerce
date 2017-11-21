package br.unibh.tcc.commerce.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import br.unibh.tcc.commerce.model.Product;
import br.unibh.tcc.commerce.model.service.ProductService;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	private ModelAndView getProducts(){
		ModelAndView mv = new ModelAndView("/commerce");
		mv.addObject("products",productService.findAll());
		return mv;
	}
	
	@GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return add(productService.findById(id));
    }
	
	@GetMapping("/add")
    public ModelAndView add(Product product) {
         
        ModelAndView mv = new ModelAndView("/productAdd");
        mv.addObject("product", product);
         
        return mv;
    }
	
	@PostMapping("/product/save")
    public ModelAndView save(@Valid Product product, BindingResult result) {
         
        if(result.hasErrors()) {
            return add(product);
        }
         
        productService.save(product);
        
        return getProducts();
    }
	
	@PostMapping("/product")
	private Product saveProduct(@RequestBody Product product){
		return productService.save(product);
	}
	
}
