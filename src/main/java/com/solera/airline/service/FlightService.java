package com.solera.airline.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.solera.airline.model.*;

@Component
public class FlightService {
	
	private List<Flight> flights = Arrays.asList(
			new Flight(1, "Madrid", "Seville", 50, LocalDateTime.of(2023, 01, 10, 12, 00), true, 0, "RyanAir"),
			new Flight(2, "Madrid", "Lisbon", 100, LocalDateTime.of(2023, 01, 12, 12, 00), false, 0, "RyanAir"),
			new Flight(3, "Madrid", "Berlin", 200, LocalDateTime.of(2023, 01, 17, 12, 00), true, 1, "TAP"),
			new Flight(4, "Madrid", "Paris", 150, LocalDateTime.of(2023, 01, 9, 12, 00), true, 1, "TAP"),
			new Flight(5, "Madrid", "Milan", 125, LocalDateTime.of(2023, 01, 14, 12, 00), true, 2, "EasyJet"),
			new Flight(6, "London", "Seville", 200, LocalDateTime.of(2023, 01, 10, 12, 00), true, 0, "RyanAir"),
			new Flight(7, "London", "Lisbon", 40, LocalDateTime.of(2023, 01, 11, 12, 00), false, 0, "RyanAir"),
			new Flight(8, "London", "Munich", 80, LocalDateTime.of(2023, 01, 13, 12, 00), true, 0, "TAP"),
			new Flight(9, "London", "Turin", 105, LocalDateTime.of(2023, 01, 8, 12, 00), true, 1, "TAP"),
			new Flight(10, "London", "Athens", 175, LocalDateTime.of(2023, 01, 3, 12, 00), true, 2, "EasyJet"));
	
	public List<Flight> findAll(){
		return flights;
	}
}
