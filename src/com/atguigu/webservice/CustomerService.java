package com.atguigu.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.atguigu.entity.Customer;


@Path("/crm")
public interface CustomerService {

	
	@Path("/customer/{id}")
	@GET
	@Produces("application/json")
	 public Customer getCustomerById(String id) ;
	 
	 
}
