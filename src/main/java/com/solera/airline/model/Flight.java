package com.solera.airline.model;

import java.time.LocalDateTime;
import javax.persistence.*;

public class Flight {
	
	// -----
	// All the variables to be stored as flight info
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto generates a new and unique ID for the object
	private int flightId;
	private String departureAirport;
	private String arrivalAirport;
	private double price;
	private LocalDateTime date;
	private boolean luggage;
	
	// End of variable declaration
	// -----

	// *****
	// Constructors
	// Does not construct with @param(flightId) because this value is automatically added
	
	public Flight(int id, String departure, String arrival, double price, LocalDateTime date, boolean luggage) {
		this.departureAirport = departure;
		this.arrivalAirport = arrival;
		this.price = price;
		this.date = date;
		this.luggage = luggage;
	}
	
	// End of constructors
	// *****
	
	// +++++
	// Getters and Setter declaration
	
	// Getters
	public int getFlightId() {
		return flightId;
	}
	
	public String getDepartureAirport() {
		return departureAirport;
	}
	
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	
	public double getPrice() {
		return price;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public boolean getLuggage() {
		return luggage;
	}
	
	//Setter
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	
	public void setDepartureAirport(String departure) {
		this.departureAirport = departure;
	}
	
	public void setArrivalAirport(String arrival) {
		this.arrivalAirport = arrival;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public void setLuggage(boolean luggage) {
		this.luggage = luggage;
	}
	
	// End of Getters and Setters
	// +++++
	
	
}
