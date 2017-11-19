package br.unibh.tcc.commerce;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CommerceApplication {
	
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC-3"));
	}

	public static void main(String[] args) {
		SpringApplication.run(CommerceApplication.class, args);
	}
}
