package com.atguigu.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.atguigu.entity.Customer;
import com.google.gson.Gson;

@Path("/crm")
public class CustomerServiceImpl implements CustomerService {

	@Path("/customer/{id}")
	@GET
	@Produces("application/json")
	public Customer getCustomerById(@PathParam(value="id") String id) {
		// TODO Auto-generated method stub
		return new Customer("0101","Jack",23);
	}
	
	
	
	@Path("/addcustomer")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String addCustomer(String customerjson){
		Gson gson=new Gson();
		Customer customer=(Customer) gson.fromJson(customerjson, Customer.class);
		System.out.println(customer.toString());
		return "ok";
	}
	

}
