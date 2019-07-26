package com.hand.exam1.service.impl;

import com.hand.exam1.entity.Address;
import com.hand.exam1.entity.AddressExample;
import com.hand.exam1.mapper.AddressMapper;
import com.hand.exam1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;
	@Override
	public Short findByAddress(String address) {
		AddressExample example = new AddressExample();
		AddressExample.Criteria criteria = example.createCriteria();
		criteria.andAddressEqualTo(address);
		List<Address> filmList=addressMapper.selectByExample(example);
		if (filmList.size()>0){
			return filmList.get(0).getAddressId();
		}
		return 1;
	}
}
