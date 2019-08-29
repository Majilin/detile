package com.order.detile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class DetileApplication {
/*
* 总开关  不要乱改
* */
	public static void main(String[] args) {
		SpringApplication.run(DetileApplication.class, args);
	}

}
