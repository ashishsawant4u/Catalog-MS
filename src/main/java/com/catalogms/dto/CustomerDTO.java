package com.catalogms.dto;

public class CustomerDTO 
{
	private String customerUid;
	
	private String name;

	private String emailid;

	public CustomerDTO(String customerUid, String name, String emailid) {
		super();
		this.customerUid = customerUid;
		this.name = name;
		this.emailid = emailid;
	}

	

	public String getEmailid() {
		return emailid;
	}



	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}



	public String getCustomerUid() {
		return customerUid;
	}

	public void setCustomerUid(String customerUid) {
		this.customerUid = customerUid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "CustomerDTO [customerUid=" + customerUid + ", name=" + name + ", emailid=" + emailid + "]";
	}
	
	
	
}
