package com.baioretto.wishbottle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baioretto.wishbottle.mapper")
public class WishbottleApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishbottleApplication.class, args);
	}

}
