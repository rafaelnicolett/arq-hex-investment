package br.com.rafaelnicolei.education.investment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class InvestmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentApplication.class, args);
	}

}
