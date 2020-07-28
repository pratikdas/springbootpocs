package io.pratik.springlogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringloggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringloggerApplication.class, args);
		log.info("starting application ");
	}

}
