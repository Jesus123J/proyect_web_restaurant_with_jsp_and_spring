package com.proyect.racoonbrothers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class RacoonbrothersApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacoonbrothersApplication.class, args);
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		System.out.println(encoder.encode("12345678"));
//		System.out.println("$2a$10$n2X4MTha61ZmelkFV8aEweF1lWBM89OTHLf8/Wdu4x1lUzAE07ZF2");
//		System.out.println(new Date());
	}

}
