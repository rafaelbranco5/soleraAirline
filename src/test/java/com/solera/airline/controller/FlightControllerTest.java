package com.solera.airline.controller;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

import org.testng.annotations.Test;


public class FlightControllerTest {

	HttpClient client = HttpClient.newBuilder().build();
	
	@Test
	public void ensureThatUserApiCallAllFlightsReturnsCode200() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/allFlights")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		assertThat(response.statusCode()).isEqualTo(200);
  }
	@Test
	public void ensureThatUserApiCallAllFlightsReturnsJsonContent() throws Exception {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/allFlights")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		Optional<String> firstValue = response.headers().firstValue("Content-Type");
		String string = firstValue.get();
		assertThat(string).startsWith("application/json");
	}

	@Test // RE-DO
	public void ensureThatApiCallFlightByAirlineReturnsCode200() throws Exception {
		String airline = "tap";
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/airline/" + airline)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		assertThat(response.statusCode()).isEqualTo(200);
  }
	@Test
	public void ensureThatUserApiCallFlightsByAirlineReturnsJsonContent() throws Exception {
		String airline = "tap";
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/airline/" + airline)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		Optional<String> firstValue = response.headers().firstValue("Content-Type");
		String string = firstValue.get();
		assertThat(string).startsWith("application/json");
	}
}
