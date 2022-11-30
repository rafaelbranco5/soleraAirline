package com.solera.airline.controller;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

import org.testng.annotations.DataProvider;
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

	@DataProvider(name = "flightByAirline")
	public String[] dataForFlightByAirlineTest() {
		return new String[] {"ryanair", "tap", "easyjet"};
	}
	@Test(dataProvider = "flightByAirline")
	public void ensureThatApiCallFlightByAirlineReturnsCode200(String airline) throws Exception {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/airline/" + airline)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		assertThat(response.statusCode()).isEqualTo(200);
  }
	@Test(dataProvider = "flightByAirline")
	public void ensureThatUserApiCallFlightsByAirlineReturnsJsonContent(String airline) throws Exception {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/airline/" + airline)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		Optional<String> firstValue = response.headers().firstValue("Content-Type");
		String string = firstValue.get();
		assertThat(string).startsWith("application/json");
	}

	// Was having problems trying ot pass an array of int, but since URI.create takes in a String decided to pass the values as a String array
	@DataProvider(name = "flightsByNumberOfScales")
	public String[] dataForFlightsByScalesTest() {
		return new String[] {"0", "1", "2"};
	}
	@Test(dataProvider = "flightsByNumberOfScales")
	public void ensureThatUserApiCallScalesReturnsCode200(String numOfScales) throws Exception {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/scales/" + numOfScales)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		assertThat(response.statusCode()).isEqualTo(200);
	}
	@Test(dataProvider = "flightsByNumberOfScales")
	public void ensureThatUserApiCallScalesReturnsJsonContent(String numOfScales) throws Exception {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/scales/" + numOfScales)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		Optional<String> firstValue = response.headers().firstValue("Content-Type");
		String string = firstValue.get();
		assertThat(string).startsWith("application/json");
	}
	
	@DataProvider(name = "flightByLuggageCheck")
	public String[] dataForFlightByLuggageTest() {
		return new String[] {"true", "false"};
	}
}
