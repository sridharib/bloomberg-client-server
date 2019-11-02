package com.example.client.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ClientController.class)
@Import(ClientController.class)
public class ClientApplicationControllerTests {

	private WebClient webClient;

	private MockWebServer server;

	@After
	public void shutdown() throws Exception {
		this.server.shutdown();
	}

	@Test
	public void whenAddCalledThenExpectOk() throws Exception {

		this.server = new MockWebServer();
		String baseUrl = this.server.url("/").toString();
		this.webClient = WebClient.create(baseUrl);
		this.server.enqueue(new MockResponse().setResponseCode(200).setBody("200.00"));

		ResponseSpec retrieve = webClient.get().uri("/add?augend={0}&addend={1}", 100, 100).retrieve();

		assertEquals("200.00", retrieve.bodyToMono(String.class).block());

	}

	@Test
	public void whenSubtractCalledThenExpectOk() throws Exception {

		this.server = new MockWebServer();
		String baseUrl = this.server.url("/").toString();
		this.webClient = WebClient.create(baseUrl);
		this.server.enqueue(new MockResponse().setResponseCode(200).setBody("200.00"));

		ResponseSpec retrieve = webClient.get().uri("/api/v1/subtract?minuend={0}&subtrahend={1}", 300, 100).retrieve();

		assertEquals("200.00", retrieve.bodyToMono(String.class).block());

	}

	@Test
	public void whenMultiplyCalledThenExpectOk() throws Exception {

		this.server = new MockWebServer();
		String baseUrl = this.server.url("/").toString();
		this.webClient = WebClient.create(baseUrl);
		this.server.enqueue(new MockResponse().setResponseCode(200).setBody("10000.00"));

		ResponseSpec retrieve = webClient.get().uri("/api/v1/multiply?multiplier={0}&multiplicand={1}", 100, 100)
				.retrieve();

		assertEquals("10000.00", retrieve.bodyToMono(String.class).block());

	}

	@Test
	public void whenDivideCalledThenExpectOk() throws Exception {

		this.server = new MockWebServer();
		String baseUrl = this.server.url("/").toString();
		this.webClient = WebClient.create(baseUrl);
		this.server.enqueue(new MockResponse().setResponseCode(200).setBody("1.00"));

		ResponseSpec retrieve = webClient.get().uri("/api/v1/divide?dividend={0}&divisor={1}", 100, 100).retrieve();

		assertEquals("1.00", retrieve.bodyToMono(String.class).block());

	}

}
