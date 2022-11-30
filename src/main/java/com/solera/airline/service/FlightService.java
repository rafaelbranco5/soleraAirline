package com.solera.airline.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.solera.airline.model.*;

@Component
public class FlightService {
	
	private String[] departureCities = {"Madrid", "London", "Seville", "Berlin", "Lisbon"};
	private String[] arrivalCities = {"Paris", "Munich", "Glasgow"};
	Random rand = new Random();
	
	private List<Flight> flights = Arrays.asList(
			new Flight(1, departureCities[rand.nextInt(departureCities.length)], arrivalCities[rand.nextInt(arrivalCities.length)], 50, LocalDateTime.of(2023, 01, 10, 12, 00), "true", 0, "RyanAir", 0.5),
			new Flight(2, departureCities[rand.nextInt(departureCities.length)], arrivalCities[rand.nextInt(arrivalCities.length)], 100, LocalDateTime.of(2023, 01, 12, 12, 00), "false", 0, "RyanAir", 1),
			new Flight(3, departureCities[rand.nextInt(departureCities.length)], arrivalCities[rand.nextInt(arrivalCities.length)], 200, LocalDateTime.of(2023, 01, 17, 20, 00), "true", 1, "TAP", 2.5),
			new Flight(4, departureCities[rand.nextInt(departureCities.length)], arrivalCities[rand.nextInt(arrivalCities.length)], 150, LocalDateTime.of(2023, 01, 9, 20, 00), "true", 1, "TAP", 2),
			new Flight(5, departureCities[rand.nextInt(departureCities.length)], arrivalCities[rand.nextInt(arrivalCities.length)], 125, LocalDateTime.of(2023, 01, 14, 12, 00), "true", 2, "EasyJet", 1.5),
			new Flight(6, departureCities[rand.nextInt(departureCities.length)], arrivalCities[rand.nextInt(arrivalCities.length)], 200, LocalDateTime.of(2023, 01, 10, 12, 00), "true", 0, "RyanAir", 2),
			new Flight(7, departureCities[rand.nextInt(departureCities.length)], arrivalCities[rand.nextInt(arrivalCities.length)], 40, LocalDateTime.of(2023, 01, 11, 7, 00), "false", 0, "RyanAir", 2),
			new Flight(8, departureCities[rand.nextInt(departureCities.length)], arrivalCities[rand.nextInt(arrivalCities.length)], 80, LocalDateTime.of(2023, 01, 13, 12, 00), "true", 0, "TAP", 2),
			new Flight(9, departureCities[rand.nextInt(departureCities.length)], arrivalCities[rand.nextInt(arrivalCities.length)], 105, LocalDateTime.of(2023, 01, 8, 1, 00), "true", 1, "TAP", 3),
			new Flight(10, departureCities[rand.nextInt(departureCities.length)], arrivalCities[rand.nextInt(arrivalCities.length)], 175, LocalDateTime.of(2023, 01, 3, 23, 00), "true", 2, "EasyJet", 5));
	
	public List<Flight> findAll(){
		return flights;
	}
	
	public List<Flight> findByAirline(String requestedAirline){
		List<Flight> flightsInAirline = flights.stream()
				.filter(a -> Objects.equals(a.getAirline().toLowerCase(), requestedAirline.toLowerCase()))
				.collect(Collectors.toList());
				
		return flightsInAirline;
	}
	
	public List<String> findDepartureFlight(){
		return Arrays.asList(departureCities);
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	public HashSet<String> findArrivalFlight(){
		List<String> arrivalAirports = null;
		for (var s : flights) {
			arrivalAirports.add(s.getArrivalAirport());
		}
		Set hashSet = new HashSet(arrivalAirports);
		hashSet.addAll(arrivalAirports);
		return (HashSet<String>) hashSet;
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
