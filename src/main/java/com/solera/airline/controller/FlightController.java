package com.solera.airline.controller;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/allFlights")
	public List<Flight> retrieveAllFlights(){
		return service.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/departureFlights")
	public List<String> retrieveDepartureFlight(){
		return service.findDepartureFlight();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/arrivalFlight")
	public List<String> retrieveArrivalFlight(){
		return service.findArrivalFlight();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/airline/{airline}")
	public List<Flight> retrieveByAirline(@PathVariable String airline){
		return service.findByAirline(airline);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/scales/{numberOfScales}")
	public List<Flight> retrieveBysacles(@PathVariable int numberOfScales){
		return service.findByMaxScales(numberOfScales);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/luggage/{luggageCheck}")
	public List<Flight> retrieveByLuggage(@PathVariable String luggageChack){
		return service.findByAllowedOrDissalloedLuggage(luggageChack);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/departureFrom/{departureCity}")
	public List<Flight> retrieveByDepartureCity(@PathVariable String departureCity){
		return service.findByDepartureCity(departureCity);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/departure/{departureCity}/day/{departureDay}")
	public List<Flight> retieveSchedule(@PathVariable String departureCity, @RequestParam(value = "departureDay") 
																			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDay){
		return service.findAvailableSchedule(departureCity, departureDay);
	}
}
