package com.lguplus.LTF2_BE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ltf2BeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ltf2BeApplication.class, args);
	}

}
