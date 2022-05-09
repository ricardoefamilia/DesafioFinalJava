package br.com.desafiofinalspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafiofinalspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiofinalspringbootApplication.class, args);
	}

}
