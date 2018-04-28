package io.fireants.pitchersfriend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MlbApiApp {

	public static void main(String[] args) {
		SpringApplication.run(MlbApiApp.class, args);
	}

}
