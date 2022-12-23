package com.catalogms.controller;

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

import com.catalogms.dto.CustomerDTO;
import com.catalogms.services.CustomerService;

import jakarta.annotation.Resource;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController 
{
	@Resource(name = "customerService")
	CustomerService customerService;
	
	@GetMapping("/{customerUid}")
	public CustomerDTO getCustomer(@PathVariable("customerUid") String customerUid)
	{
		return customerService.getCustomer(customerUid);
	}
	
	@PostMapping
	public ResponseEntity addCustomer(@RequestBody CustomerDTO dto)
	{
		CustomerDTO savedDto = customerService.addCustomer(dto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "/api/customer/"+savedDto.getCustomerUid());
		
		return new ResponseEntity<>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{customerUid}")
	public ResponseEntity updateCustomer(@PathVariable("customerUid") String customerUid,@RequestBody CustomerDTO dto)
	{
		CustomerDTO savedDto = customerService.updateCustomer(dto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "/api/customer/"+savedDto.getCustomerUid());
		
		return new ResponseEntity<>(headers,HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "/{customerUid}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customerUid") String customerUid)
	{
		customerService.deleteCustomer(customerUid);
	}
}
