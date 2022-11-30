package com.solera.airline.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.solera.airline.model.*;

@Component
public class FlightService {
	
	private List<Flight> flights = Arrays.asList(
			new Flight(1, "Madrid", "Seville", 50, LocalDateTime.of(2023, 01, 10, 12, 00), "true", 0, "RyanAir", 0.5),
			new Flight(2, "Madrid", "Lisbon", 100, LocalDateTime.of(2023, 01, 12, 12, 00), "false", 0, "RyanAir", 1),
			new Flight(3, "Madrid", "Berlin", 200, LocalDateTime.of(2023, 01, 17, 20, 00), "true", 1, "TAP", 2.5),
			new Flight(4, "Madrid", "London", 150, LocalDateTime.of(2023, 01, 9, 20, 00), "true", 1, "TAP", 2),
			new Flight(5, "Madrid", "Milan", 125, LocalDateTime.of(2023, 01, 14, 12, 00), "true", 2, "EasyJet", 1.5),
			new Flight(6, "London", "Seville", 200, LocalDateTime.of(2023, 01, 10, 12, 00), "true", 0, "RyanAir", 2),
			new Flight(7, "London", "Madrid", 40, LocalDateTime.of(2023, 01, 11, 7, 00), "false", 0, "RyanAir", 2),
			new Flight(8, "London", "Munich", 80, LocalDateTime.of(2023, 01, 13, 12, 00), "true", 0, "TAP", 2),
			new Flight(9, "London", "Turin", 105, LocalDateTime.of(2023, 01, 8, 1, 00), "true", 1, "TAP", 3),
			new Flight(10, "London", "Athens", 175, LocalDateTime.of(2023, 01, 3, 23, 00), "true", 2, "EasyJet", 5));
	
	public List<Flight> findAll(){
		return flights;
	}
	
	public List<Flight> findByAirline(String requestedAirline){
		List<Flight> flightsInAirline = flights.stream()
				.filter(a -> Objects.equals(a.getAirline().toLowerCase(), requestedAirline.toLowerCase()))
				.collect(Collectors.toList());
				
		return flightsInAirline;
	}

	public List<Flight> findByMaxScales(int numberOfScales) {
		List<Flight> flightByNumOfSacles = flights.stream()
				.filter(a -> a.getScales() <= numberOfScales)
				.collect(Collectors.toList());
		return flightByNumOfSacles;
	}
	
	public List<Flight> findByAllowedOrDissalloedLuggage(String luggageCheck){
		List<Flight> flightByAllowedOrDissallowedLuggage = flights.stream()
				.filter(a -> Objects.equals(a.getLuggage().toLowerCase(), luggageCheck.toLowerCase()))
				.collect(Collectors.toList());
		return flightByAllowedOrDissallowedLuggage;
	}
}
