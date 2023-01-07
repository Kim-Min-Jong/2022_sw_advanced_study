package com.mycom.myapp.dto;

import java.util.List;

public class ProductResultDto {
	private int result;
	private ProductDto dto;
	private List<ProductDto> list;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public ProductDto getDto() {
		return dto;
	}
	public void setDto(ProductDto dto) {
		this.dto = dto;
	}
	public List<ProductDto> getList() {
		return list;
	}
	public void setList(List<ProductDto> list) {
		this.list = list;
	}
	
	public ProductResultDto() {}
	public ProductResultDto(int result, ProductDto dto, List<ProductDto> list) {
		super();
		this.result = result;
		this.dto = dto;
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "ProductResultDto [result=" + result + ", dto=" + dto + ", list=" + list + "]";
	}	
}
