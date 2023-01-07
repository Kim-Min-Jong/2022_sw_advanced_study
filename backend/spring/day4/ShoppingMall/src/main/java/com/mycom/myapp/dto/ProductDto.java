package com.mycom.myapp.dto;

public class ProductDto {
	private int productId;
	private String productName;
	private String productImageUrl;
	private String productRegisterDate;
	private int productStock;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	public String getProductRegisterDate() {
		return productRegisterDate;
	}
	public void setProductRegisterDate(String productRegisterDate) {
		this.productRegisterDate = productRegisterDate;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	
	public ProductDto() {}
	public ProductDto(int productId, String productName, String productImageUrl, String productRegisterDate,
			int productStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImageUrl = productImageUrl;
		this.productRegisterDate = productRegisterDate;
		this.productStock = productStock;
	}
	
	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", productImageUrl="
				+ productImageUrl + ", productRegisterDate=" + productRegisterDate + ", productStock=" + productStock
				+ "]";
	}
}

