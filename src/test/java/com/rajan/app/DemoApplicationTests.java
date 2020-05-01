package com.rajan.app;

import com.rajan.representation.OperandsRepresentation;
import com.rajan.response.ResultResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;


import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	private String getBaseUrl() {
		return "http://localhost:9091";
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testAdd() {
		String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary(("user" + ":" + "pass").getBytes());
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		requestHeaders.add("Authorization", authorizationHeader);

		OperandsRepresentation operands = new OperandsRepresentation("100", "50");
		HttpEntity<OperandsRepresentation> entity = new HttpEntity<>(operands, requestHeaders);
		ResponseEntity<ResultResponse> response = restTemplate.exchange(getBaseUrl() + "/api/add",
				HttpMethod.POST, entity, ResultResponse.class);
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(response.getBody().getResult(), 150);
	}

	@Test
	public void testDiff() {
		String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary(("user" + ":" + "pass").getBytes());
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		requestHeaders.add("Authorization", authorizationHeader);

		OperandsRepresentation operands = new OperandsRepresentation("100", "50");
		HttpEntity<OperandsRepresentation> entity = new HttpEntity<>(operands, requestHeaders);
		ResponseEntity<ResultResponse> response = restTemplate.exchange(getBaseUrl() + "/api/diff",
				HttpMethod.POST, entity, ResultResponse.class);
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(response.getBody().getResult(), 50);
	}

}
