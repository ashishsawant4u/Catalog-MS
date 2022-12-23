package com.catalogms.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.catalogms.dto.CustomerDTO;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	public CustomerDTO getCustomer(String uid) 
	{
		return new CustomerDTO("294030234", "James D" ,"james.d@gmail.com");
	}

	@Override
	public CustomerDTO addCustomer(CustomerDTO CustomerDTO) 
	{
		log.info("adding customer "+CustomerDTO);
		
		return CustomerDTO;
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO CustomerDTO) 
	{
		log.info("update customer "+CustomerDTO);
		
		return CustomerDTO;
	}

	@Override
	public void deleteCustomer(String code) 
	{
		log.info("deleting customer "+code);
	}
}
