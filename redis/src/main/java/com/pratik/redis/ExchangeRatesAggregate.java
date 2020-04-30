/**
 * 
 */
package com.pratik.redis;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Pratik Das
 *
 */
@Data
@AllArgsConstructor
public class ExchangeRatesAggregate implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long lastUpdateTime;
	
	private List<ExchangeRate> rates;

}
