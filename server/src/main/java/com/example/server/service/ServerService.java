package com.example.server.service;

import java.math.BigDecimal;

/**
 * Server service class
 * 
 * @author sridhar
 *
 */
public interface ServerService {

	/**
	 * Method to add two numbers
	 * 
	 * @param augend
	 * @param addend
	 * @return Addition of two numbers
	 */
	public BigDecimal add(BigDecimal augend, BigDecimal addend);

	/**
	 * Method to subtract two numbers
	 * 
	 * @param minuend
	 * @param subtrahend
	 * @return Subtraction of two numbers
	 */
	public BigDecimal subtract(BigDecimal minuend, BigDecimal subtrahend);

	/**
	 * Method to multiply two numbers
	 * 
	 * @param multiplier
	 * @param multiplicand
	 * @return Multiplication of two numbers
	 */
	public BigDecimal multiply(BigDecimal multiplier, BigDecimal multiplicand);

	/**
	 * Method to divide two numbers
	 * 
	 * @param dividend
	 * @param divisor
	 * @return Division of two numbers
	 */
	public BigDecimal divide(BigDecimal dividend, BigDecimal divisor);
}
