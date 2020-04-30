/**
 * 
 */
package com.pratik.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pratik Das
 *
 */
@RestController
@Slf4j
public class ExchangeRateController {
	
	private ExchangeRateService exchangeRateService;
	
	
	@Autowired
	public ExchangeRateController(ExchangeRateService exchangeRateService) {
		super();
		this.exchangeRateService = exchangeRateService;
	}

    
    @GetMapping("/rates")
	public List<ExchangeRate> fetchExchangeRates(){
		return fetchExchangeRates("ALL").getRates();
	}
    
    @GetMapping("/clear")
 	public void clearExchangeRates(){
 		exchangeRateService.clearCache();
 		ExchangeRatesAggregate exchangeRatesAggregate = exchangeRateService.fetchExchangeRatesFromCache("ALL");
		List<ExchangeRate> rates = exchangeRatesAggregate.getRates();
		log.info("fetching rates from cache {} rows", rates!=null?rates.size():0);

 	}
    
    private ExchangeRatesAggregate fetchExchangeRates(String currencyPairs){
		log.info("fetching rates ");
		ExchangeRatesAggregate exchangeRatesAggregate = exchangeRateService.fetchExchangeRatesFromCache("ALL");
		if( exchangeRatesAggregate == null || exchangeRatesAggregate.getRates() == null || exchangeRatesAggregate.getRates().isEmpty()) {
			log.info("fetching rates cache miss");
			exchangeRatesAggregate = exchangeRateService.updateExchangeRatesInCache("ALL");
			log.info("fetching rates after updating cache {} rows", exchangeRatesAggregate.getRates().size());
			return exchangeRatesAggregate;
		}
		log.info("fetching rates cache hit {} rows", exchangeRatesAggregate!=null?exchangeRatesAggregate.getRates().size():0);
		return exchangeRatesAggregate;
	}

}
