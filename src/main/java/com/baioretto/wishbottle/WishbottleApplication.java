package com.baioretto.wishbottle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.baioretto.wishbottle.mapper")
@EnableCaching
public class WishbottleApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishbottleApplication.class, args);
	}

}
