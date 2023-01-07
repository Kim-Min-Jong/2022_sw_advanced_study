package com.mycom.myapp.service;

import com.mycom.myapp.dto.ProductDto;
import com.mycom.myapp.dto.ProductResultDto;


public interface ProductService {

	ProductResultDto productInsert(ProductDto productDto);
	ProductResultDto productUpdate(ProductDto productDto);
	ProductResultDto productDelete(int produtId);

	ProductResultDto productList();
	ProductResultDto productListSearchWord(String searchWord);

	ProductResultDto productDetail(int produtId);

}
