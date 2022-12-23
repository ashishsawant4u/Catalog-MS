package com.catalogms.controller;



import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.catalogms.dto.ProductDTO;
import com.catalogms.services.ProductService;

import jakarta.annotation.Resource;

@RequestMapping("/api/v1/product")
@RestController
public class ProductsController 
{
	@Resource(name = "productService")
	ProductService productService;
	
	@GetMapping(value = "/{productCode}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable("productCode") String productCode)
	{
		return new ResponseEntity<>(productService.getProduct(productCode),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity addProduct(@RequestBody ProductDTO dto)
	{
		ProductDTO savedDto = productService.addProduct(dto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "/api/product/"+savedDto.getCode());
		
		return new ResponseEntity<>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{productCode}")
	public ResponseEntity updateProduct(@PathVariable("productCode") String productCode,@RequestBody ProductDTO dto)
	{
		ProductDTO savedDto = productService.updateProduct(dto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "/api/product/"+savedDto.getCode());
		
		return new ResponseEntity<>(headers,HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "/{productCode}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable("productCode") String productCode)
	{
		productService.deleteProduct(productCode);
	}
	
	@GetMapping(value = "/search/{searchTerm}")
	public ResponseEntity<List<ProductDTO>> searchProducts(@PathVariable("searchTerm") String searchTerm)
	{
		return new ResponseEntity<>(productService.searchProduct(searchTerm),HttpStatus.OK);
	}
}
