package com.mycom.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.dto.ProductDto;
import com.mycom.myapp.dto.ProductResultDto;
import com.mycom.myapp.service.ProductService;

@RestController
@CrossOrigin(
		// localhost:5500 과 127.0.0.1 구분
		origins = "http://127.0.0.1:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class ProductController {

	@Autowired
	ProductService service;

	// REST API
	// 등록 /books POST
	// 수정 /books/123 PUT
	// 삭제 /books/123 DELETE
	// 조회 /books GET
	// 상세 /books/123 GET

	@GetMapping(value="/products")
	public ProductResultDto productList(String searchWord){
		
		ProductResultDto productResultDto;
		System.out.println(searchWord);
		if( searchWord == null ) {
			productResultDto = service.productList();
		}else {
			productResultDto = service.productListSearchWord(searchWord);
		}
		
		return productResultDto;
	}

	
	@GetMapping(value="/products/{productId}")
	public ProductResultDto productDetail(@PathVariable int productId){

		ProductResultDto productResultDto = service.productDetail(productId);
		return productResultDto;		 
	}
	
	@PostMapping(value="/products")
	public ProductResultDto productInsert( ProductDto productDto ) {

		ProductResultDto productResultDto = service.productInsert(productDto);
		return productResultDto;		 
	}

	@PutMapping(value="/products/{productId}") 
	public ProductResultDto productUpdate(ProductDto productDto){

		ProductResultDto productResultDto = service.productUpdate(productDto);
		return productResultDto;		
	}
	
	@DeleteMapping(value="/products/{productId}") 
	public ProductResultDto productDelete(@PathVariable int productId){
		ProductResultDto productResultDto = service.productDelete(productId);
		return productResultDto;		 
	}
}
