package com.atguigu.webservice;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JAXRSServerFactoryBean jaxrsServerFactoryBean=new JAXRSServerFactoryBean();
		jaxrsServerFactoryBean.setAddress("http://localhost:8080/restws");
		jaxrsServerFactoryBean.setResourceClasses(CustomerServiceImpl.class);
		jaxrsServerFactoryBean.create().start();
		
	}

}
