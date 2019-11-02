package com.example.server.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class ServerServiceImplTest {

	@Test
	public void whenAddCalledThenExpectResult() {
		
		ServerService service = new ServerServiceImpl();
		BigDecimal add = service.add(new BigDecimal(100), new BigDecimal(200));
		
		assertEquals(new BigDecimal(300), add);
	}
	
	@Test
	public void whenSubtractCalledThenExpectResult() {
		
		ServerService service = new ServerServiceImpl();
		BigDecimal subtract = service.subtract(new BigDecimal(100), new BigDecimal(200));
		
		assertEquals(new BigDecimal(-100), subtract);
	}
	
	@Test
	public void whenMultiplyCalledThenExpectResult() {
		
		ServerService service = new ServerServiceImpl();
		BigDecimal multiply = service.multiply(new BigDecimal(100), new BigDecimal(200));
		
		assertEquals(new BigDecimal(20000), multiply);
	}
	
	@Test
	public void whenDivideCalledThenExpectResult() {
		
		ServerService service = new ServerServiceImpl();
		BigDecimal divide = service.divide(new BigDecimal(200), new BigDecimal(200));
		
		assertEquals(new BigDecimal(1), divide);
	}
	
	@Test
	public void whenDivideByZeroCalledThenExpectResult() {
		
		ServerService service = new ServerServiceImpl();
		BigDecimal divide = service.divide(new BigDecimal(200), new BigDecimal(0));
		
		assertEquals(BigDecimal.ZERO, divide);
	}
}
