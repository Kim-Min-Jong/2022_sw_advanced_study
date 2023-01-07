package com.mycom.myapp.dao;

import java.util.List;

import com.mycom.myapp.dto.ProductDto;

public interface ProductDao {

	int productInsert(ProductDto productDto);
	int productUpdate(ProductDto productDto);
	int productDelete(int productId);

	List<ProductDto> productList();	
	List<ProductDto> productListSearchWord(String searchWord);
	
	ProductDto productDetail(int productId);

}
