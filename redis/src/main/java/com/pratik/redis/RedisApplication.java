package com.pratik.redis;

import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class RedisApplication {

	@Autowired
	private ExchangeRateRepository exchangeRateRepository;

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}
	
	@Bean
	InitializingBean populateDB() {
		return ()->{
			exchangeRateRepository.deleteAll();
			exchangeRateRepository.save(new ExchangeRate(UUID.randomUUID().toString(), "USD","AED", 3.67));
			exchangeRateRepository.save(new ExchangeRate(UUID.randomUUID().toString(),"INR","AED", 3.67));
			exchangeRateRepository.save(new ExchangeRate(UUID.randomUUID().toString(),"GBP","AED", 3.67));
			exchangeRateRepository.save(new ExchangeRate(UUID.randomUUID().toString(),"AUD","AED", 3.67));
			exchangeRateRepository.save(new ExchangeRate(UUID.randomUUID().toString(),"JPY","AED", 3.67));
			
		
		};
	}

}
