package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.demo.payload.ProductDto;
import com.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//Create Product -- Post
	@PostMapping("/")
	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto ){
		
		ProductDto createdProduct = this.productService.createProduct(productDto);
		
		return new ResponseEntity<ProductDto>(createdProduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/{product_id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Integer product_id){
		ProductDto createdProduct = this.productService.getProductById(product_id);
        return new ResponseEntity<ProductDto>(createdProduct,HttpStatus.CREATED);
	}
	
	@PutMapping("/{product_id}")
	public ResponseEntity<ProductDto> updateProductById(@Valid @RequestBody ProductDto productDto,@PathVariable Integer product_id){
		ProductDto updatedProduct = this.productService.updateProduct(productDto, product_id);
        return new ResponseEntity<ProductDto>(updatedProduct,HttpStatus.OK);
	}
	
	@DeleteMapping("/{product_id}")
	public ResponseEntity<?> deleteProductById( @PathVariable Integer product_id){
		this.productService.deleteProduct( product_id);
        return new ResponseEntity<>("Prduct Deleted Successfully",HttpStatus.OK);
	}
	

}
