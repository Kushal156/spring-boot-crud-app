package com.demo.service;

import com.demo.payload.ProductDto;

public interface ProductService {
	//Create Product
	ProductDto createProduct(ProductDto productDto);
	
	ProductDto getProductById(Integer product_Id);
	
	ProductDto updateProduct(ProductDto productDto,Integer product_Id);
	
	void deleteProduct(Integer product_Id);
	

}
