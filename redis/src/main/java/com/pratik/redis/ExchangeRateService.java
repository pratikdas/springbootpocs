/**
 * 
 */
package com.pratik.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pratik Das
 *
 */
@Service
@Slf4j
public class ExchangeRateService {
	
	
	private ExchangeRateRepository exchangeRateRepository;
	
	
	@Autowired
	public ExchangeRateService(ExchangeRateRepository exchangeRateRepository) {
		super();
		this.exchangeRateRepository = exchangeRateRepository;
	}

	

	@Cacheable( cacheNames = "exchangeRates", value = "exchangeRates", key = "#currencyPairs" )
	public ExchangeRatesAggregate fetchExchangeRatesFromCache(String currencyPairs){
	//	log.info("fetching rates from db");
		return null;//exchangeRateRepository.findAll();
	}
	
	@CachePut(cacheNames = "exchangeRates", value = "exchangeRates", key = "#currencyPairs")
	public ExchangeRatesAggregate updateExchangeRatesInCache(String currencyPairs){
		log.info("updating rates in cache from db");
		List<ExchangeRate> rates = exchangeRateRepository.findAll();
		ExchangeRatesAggregate exchangeRatesAggregate = new ExchangeRatesAggregate(System.currentTimeMillis(), rates);
		return exchangeRatesAggregate;
		
	}
	
	@CacheEvict(cacheNames = "exchangeRates", allEntries=true)
	public void clearCache(){
	    log.info("clearing cache");
	}

}
