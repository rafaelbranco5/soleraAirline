package com.solera.airline.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/flight/{airline}")
	public List<Flight> retrieveByAirline(@PathVariable String airline){
		return service.findByAirline(airline);
	/*	if (airline.equals("tap")) {
			return "tap";
		}
		if (airline.equals("TAP")) {
			return "UPPERCASE";
		}else {
			return "none";
		}*/
		
	}
}
