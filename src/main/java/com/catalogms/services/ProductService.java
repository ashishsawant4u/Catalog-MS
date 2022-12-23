package com.catalogms.services;

import java.util.List;

import com.catalogms.dto.ProductDTO;


public interface ProductService {
	
	public ProductDTO getProduct(String code);
	
	public ProductDTO addProduct(ProductDTO productDTO);
	
	public ProductDTO updateProduct(ProductDTO productDTO);
	
	public void deleteProduct(String code);
	
	public List<ProductDTO> searchProduct(String searchTerm);

}
