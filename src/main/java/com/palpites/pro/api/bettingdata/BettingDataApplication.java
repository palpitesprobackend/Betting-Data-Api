package com.palpites.pro.api.bettingdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BettingDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(BettingDataApplication.class, args);
	}

}
