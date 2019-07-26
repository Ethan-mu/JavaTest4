package com.hand.exam1.controller;

import com.hand.exam1.common.Result;
import com.hand.exam1.entity.Customer;
import com.hand.exam1.service.CustomerService;
import com.hand.exam1.vo.CustomerVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/login/{name}/{password}",method = RequestMethod.GET)
	public Result login(@PathVariable("name") String name,@PathVariable("password") String password){
		boolean res=customerService.login(name);
		if(res){
			return new Result(200, "登录成功", res);
		}
		 return new Result(201, "登录失败", res);
	}

	@RequestMapping(value = "/add",method = RequestMethod.PUT)
	public Result add(@RequestBody CustomerVo customerVo){
		Short id=customerService.insert(customerVo);
		CustomerVo customerVo1=new CustomerVo();

		customerVo1.setCustomerId(id);
		return new Result(200,"添加成功",customerVo1);
	}


	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Result update(@RequestBody CustomerVo customerVo){
		customerService.update(customerVo);

		return new Result(200,"更新成功",customerVo);
	}

	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public Result delete(@PathVariable("id") String id){
		customerService.delete(Short.valueOf(id));
		return new Result(200,"删除成功",id);
	}
}
