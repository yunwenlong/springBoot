package com.ywl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration		
//@ComponentScan(basePackages={"com.ywl.controller","com.ywl.common","com.ywl.service"})   // 扫码控制器包
//@MapperScan(basePackages={"com.ywl.mapper","com.ywl.mybatis.mapper"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
