package com.hand.exam1.service.impl;

import com.hand.exam1.entity.Customer;
import com.hand.exam1.entity.CustomerExample;
import com.hand.exam1.mapper.CustomerMapper;
import com.hand.exam1.service.AddressService;
import com.hand.exam1.service.CustomerService;
import com.hand.exam1.vo.CustomerVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private AddressService addressService;

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Override
	public boolean login(String name) {
		CustomerExample example = new CustomerExample();
		CustomerExample.Criteria criteria = example.createCriteria();
		criteria.andFirstNameEqualTo(name);
		List<Customer> filmList=customerMapper.selectByExample(example);
		if(filmList.size()>0){

			logger.info(filmList.size()+"");
			return true;
		}
		return false;
	}

	@Override
	public void delete(Short id) {

		customerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Short insert(CustomerVo customerVo) {

		Short id=addressService.findByAddress(customerVo.getAddress());
		Customer customer=new Customer();
		customer.setAddressId(id);
		customer.setLastName(customerVo.getLastName());
		customer.setFirstName(customerVo.getFirstName());
		customer.setEmail(customer.getEmail());
		customer.setActive(true);
		customer.setAddressId((short)1);
		customer.setCreateDate(new Date());
		customer.setLastUpdate(new Date());
		customer.setStoreId((byte)1);
		customerMapper.insert(customer);
		return customer.getCustomerId();
	}

	@Override
	public void update(CustomerVo customerVo) {

		Customer customer=new Customer();
		customer.setCustomerId(customerVo.getCustomerId());
		customer.setLastName(customerVo.getLastName());
		customer.setFirstName(customerVo.getFirstName());
		customer.setEmail(customerVo.getEmail());
		customer.setActive(true);
		customer.setAddressId((short)1);
		customer.setCreateDate(new Date());
		customer.setLastUpdate(new Date());
		customer.setStoreId((byte)1);
		customerMapper.updateByPrimaryKeySelective(customer);

	}
}
