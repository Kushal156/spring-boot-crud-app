package com.demo.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Product;
import com.demo.exception.ResourceNotFoundException;
import com.demo.payload.ProductDto;
import com.demo.repositories.ProductRepo;
import com.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public ProductDto createProduct(ProductDto productDto) {
        Product product = this.modelMapper.map(productDto, Product.class);
        Product savedProduct = this.productRepo.save(product);
		ProductDto savedProductDto = this.modelMapper.map(savedProduct, ProductDto.class);
		return savedProductDto;
	}

	@Override
	public ProductDto getProductById(Integer product_Id) {
		Product product = this.productRepo.findById(product_Id).orElseThrow(() -> new ResourceNotFoundException("Product not found with Id :" +product_Id));
		ProductDto productDto = this.modelMapper.map(product, ProductDto.class);
		return productDto;
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, Integer product_Id) {
		Product product = this.productRepo.findById(product_Id).orElseThrow(() -> new ResourceNotFoundException("Entity with ID " + product_Id + " not found" ));
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		Product updateProduct = this.productRepo.save(product);
		
		ProductDto updatedProductDto = this.modelMapper.map(updateProduct, ProductDto.class);
		return updatedProductDto;
	}

	@Override
	public void deleteProduct(Integer product_Id) {

		Product product = this.productRepo.findById(product_Id).orElseThrow(() -> new ResourceNotFoundException("Entity with ID " + product_Id + " not found"));
		this.productRepo.delete(product);
	}

}
