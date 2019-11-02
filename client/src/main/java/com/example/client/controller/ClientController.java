package com.example.client.controller;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.example.client.exception.ExampleClientException;

import reactor.core.publisher.Mono;

/**
 * Client controller class
 * 
 * @author sridhar
 *
 */

@RestController
public class ClientController {

	@Value("${backend.server.url}")
	private String serverURL;

	private WebClient client;
	
	/**
	 * Post construct method
	 */
	@PostConstruct
	public void construct() {
		client = WebClient.create(serverURL);
	}

	/**
	 * Rest API to add two numbers
	 * 
	 * @param augend
	 * @param addend
	 * @return Addition of two numbers
	 */
	@GetMapping(path = "/add")
	public Mono<ResponseEntity<BigDecimal>> add(@RequestParam BigDecimal augend, @RequestParam BigDecimal addend) {

		ResponseSpec responseSpec = client.get()
				.uri("/add?augend={0}&addend={1}", augend.doubleValue(), addend.doubleValue()).retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new ExampleClientException()))
				.onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new ExampleClientException()));

		return Mono.justOrEmpty(ResponseEntity.ok(responseSpec.bodyToMono(BigDecimal.class).block()));
	}

	/**
	 * Rest API to subtract two numbers
	 * 
	 * @param minuend
	 * @param subtrahend
	 * @return Subtraction of two numbers
	 */
	@GetMapping(path = "/subtract")
	public Mono<ResponseEntity<BigDecimal>> subtract(@RequestParam BigDecimal minuend,
			@RequestParam BigDecimal subtrahend) {

		ResponseSpec responseSpec = client.get()
				.uri("/add?minuend={0}&subtrahend={1}", minuend.doubleValue(), subtrahend.doubleValue()).retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new ExampleClientException()))
				.onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new ExampleClientException()));

		return Mono.justOrEmpty(ResponseEntity.ok(responseSpec.bodyToMono(BigDecimal.class).block()));
	}

	/**
	 * Rest API to multiply two numbers
	 * 
	 * @param multiplier
	 * @param multiplicand
	 * @return Multiplication of two numbers
	 */
	@GetMapping(path = "/multiply")
	public Mono<ResponseEntity<BigDecimal>> multiply(@RequestParam BigDecimal multiplier,
			@RequestParam BigDecimal multiplicand) {

		ResponseSpec responseSpec = client.get()
				.uri("/add?multiplier={0}&multiplicand={1}", multiplier.doubleValue(), multiplicand.doubleValue())
				.retrieve().onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new ExampleClientException()))
				.onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new ExampleClientException()));

		return Mono.justOrEmpty(ResponseEntity.ok(responseSpec.bodyToMono(BigDecimal.class).block()));
	}

	/**
	 * Rest API to divide two numbers
	 * 
	 * @param dividend
	 * @param divisor
	 * @return Division of two numbers
	 */
	@GetMapping(path = "/divide")
	public Mono<ResponseEntity<BigDecimal>> divide(@RequestParam BigDecimal dividend,
			@RequestParam BigDecimal divisor) {

		ResponseSpec responseSpec = client.get()
				.uri("/add?dividend={0}&divisor={1}", dividend.doubleValue(), divisor.doubleValue()).retrieve()
				.onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new ExampleClientException()))
				.onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new ExampleClientException()));

		return Mono.justOrEmpty(ResponseEntity.ok(responseSpec.bodyToMono(BigDecimal.class).block()));
	}
}
