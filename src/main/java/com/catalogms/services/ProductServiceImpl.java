package com.catalogms.services;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.catalogms.dto.ProductDTO;

@PropertySource(value={"classpath:application.properties"})
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
	
	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	RestTemplate restTemplate;
	
	public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) 
	{
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Value("${mock.data.single.product.url}")
	private String SINGLE_PRODUCT_URL;
	
	@Value("${mock.data.search.product.url}")
	private String SEARCH_PRODUCT_URL;
	

	@Override
	public ProductDTO getProduct(String code) 
	{	   
	   return restTemplate.getForEntity(SINGLE_PRODUCT_URL, ProductDTO.class).getBody();
	}

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) 
	{
		log.info("adding produtct "+productDTO);
		
		return productDTO;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) 
	{
		log.info("update produtct "+productDTO);
		
		return productDTO;
	}

	@Override
	public void deleteProduct(String code) 
	{
		log.info("deleting produtct "+code);
	}

	@Override
	public List<ProductDTO> searchProduct(String searchTerm) 
	{		   
		   ResponseEntity<List<ProductDTO>> responseEntity = 
				   restTemplate.exchange(SEARCH_PRODUCT_URL, HttpMethod.GET, null,new ParameterizedTypeReference<List<ProductDTO>>() {});
		   List<ProductDTO> data = responseEntity.getBody();
			
		   Predicate<ProductDTO> prodfilter = (p) -> p.getCode().contains(searchTerm) || p.getName().contains(searchTerm)  || p.getDescription().contains(searchTerm);
		   
		   return data.stream().filter(prodfilter).collect(Collectors.toList());
	}

}
