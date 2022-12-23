package com.catalogms.services;

import com.catalogms.dto.CustomerDTO;

public interface CustomerService 
{
	public CustomerDTO getCustomer(String uid);
	
	public CustomerDTO addCustomer(CustomerDTO CustomerDTO);
	
	public CustomerDTO updateCustomer(CustomerDTO CustomerDTO);
	
	public void deleteCustomer(String customerUid);
}
