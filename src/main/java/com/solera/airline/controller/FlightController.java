package com.solera.airline.controller;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solera.airline.model.Flight;
import com.solera.airline.service.FlightService;

@RestController
public class FlightController {
	private FlightService service;
	
	public FlightController(FlightService service) {
		this.service = service;
	}
	
	@GetMapping("/allFlights")
	public List<Flight> retrieveAllFlights(){
		return service.findAll();
	}
	
	@GetMapping("/departureFlights")
	public List<String> retrieveDepartureFlight(){
		return service.findDepartureFlight();
	}
	
	@GetMapping("/arrivalFlight")
	public List<String> retrieveArrivalFlight(){
		return service.findArrivalFlight();
	}
	
	@GetMapping("/airline/{airline}")
	public List<Flight> retrieveByAirline(@PathVariable String airline){
		return service.findByAirline(airline);
	}
	
	@GetMapping("/scales/{numberOfScales}")
	public List<Flight> retrieveBysacles(@PathVariable int numberOfScales){
		return service.findByMaxScales(numberOfScales);
	}
	
	@GetMapping("/luggage/{luggageCheck}")
	public List<Flight> retrieveByLuggage(@PathVariable String luggageChack){
		return service.findByAllowedOrDissalloedLuggage(luggageChack);
	}
	
	@GetMapping("/departure/{departureCity}/day/{departureDay0")
	public List<Flight> retieveSchedule(@RequestParam String departureCity, @RequestParam LocalDateTime departureDay){
		return service.findAvailableSchedule();
	}
}
