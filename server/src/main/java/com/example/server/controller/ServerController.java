package com.example.server.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.service.ServerService;

import reactor.core.publisher.Mono;

/**
 * Server controller class
 * 
 * @author sridhar
 *
 */

@RestController
public class ServerController {

	@Autowired
	private ServerService serverService;

	/**
	 * Rest API to add two numbers
	 * 
	 * @param augend
	 * @param addend
	 * @return Addition of two numbers
	 */
	@GetMapping(path = "/api/v1/add")
	public Mono<ResponseEntity<BigDecimal>> add(@RequestParam BigDecimal augend, @RequestParam BigDecimal addend) {

		return Mono.justOrEmpty(ResponseEntity.ok(serverService.add(augend, addend)));
	}

	/**
	 * Rest AP"/apio subtract two numbers
	 * 
	 * @param minuend
	 * @param subtrahend
	 * @return Subtraction of two numbers
	 */
	@GetMapping(path = "/api/v1/subtract")
	public Mono<ResponseEntity<BigDecimal>> subtract(@RequestParam BigDecimal minuend,
			@RequestParam BigDecimal subtrahend) {

		return Mono.justOrEmpty(ResponseEntity.ok(serverService.subtract(minuend, subtrahend)));
	}

	/**
	 * Rest API to multiply two numbers
	 * 
	 * @param multiplier
	 * @param multiplicand
	 * @return Multiplication of two numbers
	 */
	@GetMapping(path = "/api/v1/multiply")
	public Mono<ResponseEntity<BigDecimal>> multiply(@RequestParam BigDecimal multiplier,
			@RequestParam BigDecimal multiplicand) {

		return Mono.justOrEmpty(ResponseEntity.ok(serverService.multiply(multiplier, multiplicand)));
	}

	/**
	 * Rest API to divide two numbers
	 * 
	 * @param dividend
	 * @param divisor
	 * @return Division of two numbers
	 */
	@GetMapping(path = "/api/v1/divide")
	public Mono<ResponseEntity<BigDecimal>> divide(@RequestParam BigDecimal dividend,
			@RequestParam BigDecimal divisor) {

		if (divisor.equals(BigDecimal.ZERO)) {
			return Mono.justOrEmpty(ResponseEntity.badRequest().body(null));
		}
		return Mono.justOrEmpty(ResponseEntity.ok(serverService.divide(dividend, divisor)));
	}
}
