package com.hand.exam1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.hand.exam1.mapper")
@SpringBootApplication
public class Exam1Application {

	public static void main(String[] args) {
		SpringApplication.run(Exam1Application.class, args);
	}

}
