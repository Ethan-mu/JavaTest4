package com.hand.exam1.service.impl;

import com.hand.exam1.Exam1ApplicationTests;
import com.hand.exam1.entity.Customer;
import com.hand.exam1.service.CustomerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CustomerServiceImplTest extends Exam1ApplicationTests {

	@Autowired
	private CustomerService customerService;
	@Test
	public void login() {
		boolean f=customerService.login("PATRICIA");
		System.out.println(f);
		System.out.println(f);
	}

//	@Test
//	public void add() {
//		Customer customer=new Customer();
//		customer.setEmail("123123");
//		customer.setFirstName("da");
//		customer.setLastName("bao");
//		customer.setAddressId((short) 1);
//		Short f=customerService.insert(customer);
//		System.out.println(f);
//	}
}