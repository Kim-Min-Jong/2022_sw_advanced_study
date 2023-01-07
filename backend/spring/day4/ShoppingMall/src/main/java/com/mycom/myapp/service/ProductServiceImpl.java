package com.mycom.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.myapp.dao.ProductDao;
import com.mycom.myapp.dto.ProductDto;
import com.mycom.myapp.dto.ProductResultDto;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao dao;


    @Override
    public ProductResultDto productInsert(ProductDto dto) {

        ProductResultDto productResultDto = new ProductResultDto();

        int result = dao.productInsert(dto);
        productResultDto.setResult(result);

        return productResultDto;
    }

    @Override
    public ProductResultDto productUpdate(ProductDto dto) {

        ProductResultDto productResultDto = new ProductResultDto();

        int result = dao.productUpdate(dto);
        productResultDto.setResult(result);

        return productResultDto;
    }

    @Override
    public ProductResultDto productDelete(int productId) {

        ProductResultDto productResultDto = new ProductResultDto();

        int result = dao.productDelete(productId);
        productResultDto.setResult(result);

        return productResultDto;
    }

    @Override
    @Transactional
    public ProductResultDto productDetail(int productId) {

        ProductResultDto productResultDto = new ProductResultDto();
        ProductDto productDto = dao.productDetail(productId);

        productResultDto.setDto(productDto);
        productResultDto.setResult(1);

        return productResultDto;
    }

    @Override
    public ProductResultDto productList() {

        ProductResultDto productResultDto = new ProductResultDto();

        List<ProductDto> list = dao.productList();
        productResultDto.setList(list);
        productResultDto.setResult(1);

        return productResultDto;
    }

    @Override
    public ProductResultDto productListSearchWord(String searchWord) {

        ProductResultDto productResultDto = new ProductResultDto();

        List<ProductDto> list = dao.productListSearchWord(searchWord);
        productResultDto.setList(list);
        productResultDto.setResult(1);

        return productResultDto;
    }

}