package com.hand.exam1.service.impl;

import com.hand.exam1.Exam1ApplicationTests;
import com.hand.exam1.mapper.AddressMapper;
import com.hand.exam1.service.AddressService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AddressServiceImplTest extends Exam1ApplicationTests {

	@Autowired
	private AddressService addressService;
	@Test
	public void findByAddress() {
		Short s=addressService.findByAddress("Boulevard");
		System.out.println(s);
	}
}