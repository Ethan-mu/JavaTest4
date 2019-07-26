package com.hand.exam1.service;


import com.hand.exam1.entity.Actor;
import com.hand.exam1.entity.Customer;
import com.hand.exam1.vo.CustomerVo;

import java.util.List;

public interface CustomerService {
	boolean login(String name);

	void delete(Short id);

	Short insert(CustomerVo customerVo);

	void update(CustomerVo customerVo);
}
