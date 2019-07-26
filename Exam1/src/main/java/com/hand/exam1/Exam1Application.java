package com.hand.exam1;

import com.hand.exam1.common.RequestJsonHandlerMethodArgumentResolver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@MapperScan("com.hand.exam1.mapper")
@SpringBootApplication
public class Exam1Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Exam1Application.class, args);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new RequestJsonHandlerMethodArgumentResolver());
		super.addArgumentResolvers(argumentResolvers);
	}
}
