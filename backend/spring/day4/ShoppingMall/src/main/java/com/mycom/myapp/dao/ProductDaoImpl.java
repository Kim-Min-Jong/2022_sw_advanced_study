package com.mycom.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.myapp.dto.ProductDto;

// 날짜는 문자열로 처리 => LocalDateTime 으로 개선 필요
// 파일 이미지 처리 기능 없음 => 파일 업로드 등으로 이후 개선 필요.

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	DataSource dataSource;	
	
	@Override
	public int productInsert(ProductDto productDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int ret = -1;
		
		try {

			con = dataSource.getConnection();

			// 테이블 컬럼의 default 값 대신 now() 사용해 본다.
			StringBuilder sb = new StringBuilder();

			if( productDto.getProductImageUrl() == null ||
					productDto.getProductImageUrl().equals("")   ) {
				sb.append("insert into product ( product_name, product_stock, product_register_date ) ");
				sb.append("  values ( ?, ?, now() ) ");

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setString(1, productDto.getProductName());
				pstmt.setInt(2, productDto.getProductStock());

			}else {
				sb.append("insert into product ( product_name, product_stock, product_image_url, product_register_date ) ");
				sb.append("  values ( ?, ?, ?, now() ) ");

				pstmt = con.prepareStatement(sb.toString());

				pstmt.setString(1, productDto.getProductName());
				pstmt.setInt(2, productDto.getProductStock());
				pstmt.setString(3, productDto.getProductImageUrl());
			}

			ret = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( pstmt != null ) pstmt.close();
				if( con != null ) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
	@Override
	public int productUpdate(ProductDto productDto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int ret = -1;
		
		try {
			
			con = dataSource.getConnection();
            
			StringBuilder sb = new StringBuilder();
			sb.append("update product set product_name = ?, product_stock = ?, product_image_url = ? ");
			sb.append(" where product_id = ? ");
			
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setString(1, productDto.getProductName());
			pstmt.setInt(2, productDto.getProductStock());
			pstmt.setString(3, productDto.getProductImageUrl());
			pstmt.setInt(4, productDto.getProductId());
			
			ret = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( pstmt != null ) pstmt.close();
				if( con != null ) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}

	@Override
	public int productDelete(int productId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int ret = -1;
		
		try {
			
			con = dataSource.getConnection();
            
			StringBuilder sb = new StringBuilder();
			sb.append("delete from product where product_id = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, productId);
			
			ret = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( pstmt != null ) pstmt.close();
				if( con != null ) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
	@Override
	public List<ProductDto> productList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProductDto> list = new ArrayList<>();
		
		try {
			
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("select product_id, product_name, product_image_url, product_stock, product_register_date ");
			sb.append("  from product ");
			
			pstmt = con.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				ProductDto dto = new ProductDto();
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductImageUrl(rs.getString("product_image_url"));
				dto.setProductStock(rs.getInt("product_stock"));
				dto.setProductRegisterDate(rs.getString("product_register_date"));
				list.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null ) pstmt.close();
				if( con != null ) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List<ProductDto> productListSearchWord(String searchWord) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProductDto> list = new ArrayList<>();
		
		try {
			
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("select product_id, product_name, product_image_url, product_stock, product_register_date ");
			sb.append("  from product where product_name like ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,"%" + searchWord + "%");
			
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				ProductDto productDto = new ProductDto();
				productDto.setProductId(rs.getInt("product_id"));
				productDto.setProductName(rs.getString("product_name"));
				productDto.setProductImageUrl(rs.getString("product_image_url"));
				productDto.setProductStock(rs.getInt("product_stock"));
				productDto.setProductRegisterDate(rs.getString("product_register_date"));
				list.add(productDto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null ) pstmt.close();
				if( con != null ) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public ProductDto productDetail(int productId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProductDto productDto = null;
		
		try {
			
			con = dataSource.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("select product_id, product_name, product_image_url, product_stock, product_register_date ");
			sb.append("  from product where product_id = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, productId);
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				productDto = new ProductDto();
				productDto.setProductId(rs.getInt("product_id"));
				productDto.setProductName(rs.getString("product_name"));
				productDto.setProductImageUrl(rs.getString("product_image_url"));
				productDto.setProductStock(rs.getInt("product_stock"));
				productDto.setProductRegisterDate(rs.getString("product_register_date"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null ) pstmt.close();
				if( con != null ) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return productDto;
	}

}
