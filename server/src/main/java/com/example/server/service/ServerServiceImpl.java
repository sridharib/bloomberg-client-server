package com.example.server.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

/**
 * Server service impl class
 * 
 * @author sridhar
 *
 */

@Service
public class ServerServiceImpl implements ServerService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal add(BigDecimal augend, BigDecimal addend) {

		return augend.add(addend);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal subtract(BigDecimal minuend, BigDecimal subtrahend) {
		return minuend.subtract(subtrahend);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal multiply(BigDecimal multiplier, BigDecimal multiplicand) {

		return multiplier.multiply(multiplicand);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {

		if (divisor.equals(BigDecimal.ZERO)) {
			return divisor;
		}
		return dividend.divide(divisor);
	}

}
