/**
 * 
 */
package com.pratik.redis;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pratik Das
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exchangerates")
public class ExchangeRate implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String fromCurrency;
	private String toCurrency;
	private Double exchangeRate;

}
