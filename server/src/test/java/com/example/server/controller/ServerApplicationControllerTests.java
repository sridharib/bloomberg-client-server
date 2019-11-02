package com.example.server.controller;

import static org.mockito.Mockito.times;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.server.service.ServerService;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ServerController.class)
@Import(ServerController.class)
public class ServerApplicationControllerTests {

	@Autowired
	private WebTestClient webClient;

	@MockBean
	private ServerService service;

	@Test
	public void whenAddCalledThenExpectOk() throws Exception {

		Mockito.when(service.add(new BigDecimal(100), new BigDecimal(100))).thenReturn(new BigDecimal(200));

		webClient.get().uri("/api/v1/add?augend={0}&addend={1}", 100, 100).exchange().expectStatus().isOk();

		Mockito.verify(service, times(1)).add(new BigDecimal(100), new BigDecimal(100));

	}

	@Test
	public void whenSubtractCalledThenExpectOk() throws Exception {

		Mockito.when(service.subtract(new BigDecimal(300), new BigDecimal(100))).thenReturn(new BigDecimal(200));

		webClient.get().uri("/api/v1/subtract?minuend={0}&subtrahend={1}", 300, 100).exchange().expectStatus().isOk();

		Mockito.verify(service, times(1)).subtract(new BigDecimal(300), new BigDecimal(100));

	}

	@Test
	public void whenMultiplyCalledThenExpectOk() throws Exception {

		Mockito.when(service.multiply(new BigDecimal(100), new BigDecimal(100))).thenReturn(new BigDecimal(10000));

		webClient.get().uri("/api/v1/multiply?multiplier={0}&multiplicand={1}", 100, 100).exchange().expectStatus().isOk();

		Mockito.verify(service, times(1)).multiply(new BigDecimal(100), new BigDecimal(100));

	}

	@Test
	public void whenDivideCalledThenExpectOk() throws Exception {

		Mockito.when(service.divide(new BigDecimal(100), new BigDecimal(100))).thenReturn(new BigDecimal(1));

		webClient.get().uri("/api/v1/divide?dividend={0}&divisor={1}", 100, 100).exchange().expectStatus().isOk();

		Mockito.verify(service, times(1)).divide(new BigDecimal(100), new BigDecimal(100));

	}

	@Test
	public void whenDivideByZeroCalledThenExpectBadRequest() throws Exception {

		Mockito.when(service.divide(new BigDecimal(100), new BigDecimal(0))).thenReturn(BigDecimal.ZERO);

		webClient.get().uri("/api/v1/divide?dividend={0}&divisor={1}", 100, 0).exchange().expectStatus().isBadRequest();
	}

}
