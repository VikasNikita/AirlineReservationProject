package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FlightsTable")
public class Flight
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Flight_ID")
	private int flightId;
	
	

	@Column(name="FLIGHT_NAME")
	private String flightName;
	
	@Column(name = "SOURCE_LOCATION")
	private String sourceLoc;
	
	@Column(name="DESTINATION_LOCATION")
	private String destinationLoc;
	
	@Column(name="DEPARTURE_DATE_TIME")
	private LocalDateTime departureDateTime;
	
	@Column(name="ARRIVAL_DATE_TIME")
	private LocalDateTime arrivalDateTime;
	
	@Column(name="Economy_Seat_Price")
	private int economySeatPrice;
	
	
	@Column(name="BUSINESS_SEAT_PRICE")
	private int businessSeatPrice;
	
	@Column(name="TOTAL_ECONOMY_SEATS")
	private int totalEconomySeats;
	
	@Column(name="TOTAL_BUSINESS_SEATS")
	private int totalbusinessSeats;
	
	@Column(name="AVAILABLE_ECONOMY_SEATS")
	private int availableEconomySeats;
	
	@Column(name="AVAILABLE_BUSINESS_SEATS")
	private int availableBusinessSeats;
	

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "flight")
	private Set<Bookings> bookings = new HashSet<Bookings>();

//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "flight")
//	private Set<PassengerTicketBooked> passengerTicketBookeds=new HashSet<PassengerTicketBooked>();

//	public Set<PassengerTicketBooked> getPassengerTicketBookeds() {
//		return passengerTicketBookeds;
//	}
//
//	public void setPassengerTicketBookeds(Set<PassengerTicketBooked> passengerTicketBookeds) {
//		this.passengerTicketBookeds = passengerTicketBookeds;
//	}

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(int flightId, String flightName, String sourceLoc, String destinationLoc,
			LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, int economySeatPrice, int businessSeatPrice,
			int totalEconomySeats, int totalbusinessSeats, int availableEconomySeats, int availableBusinessSeats) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.sourceLoc = sourceLoc;
		this.destinationLoc = destinationLoc;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.economySeatPrice = economySeatPrice;
		this.businessSeatPrice = businessSeatPrice;
		this.totalEconomySeats = totalEconomySeats;
		this.totalbusinessSeats = totalbusinessSeats;
		this.availableEconomySeats = availableEconomySeats;
		this.availableBusinessSeats = availableBusinessSeats;
//		this.bookings = bookings;
//		this.passengerTicketBookeds = passengerTicketBookeds;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSourceLoc() {
		return sourceLoc;
	}

	public void setSourceLoc(String sourceLoc) {
		this.sourceLoc = sourceLoc;
	}

	public String getDestinationLoc() {
		return destinationLoc;
	}

	public void setDestinationLoc(String destinationLoc) {
		this.destinationLoc = destinationLoc;
	}

	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public int getEconomySeatPrice() {
		return economySeatPrice;
	}

	public void setEconomySeatPrice(int economySeatPrice) {
		this.economySeatPrice = economySeatPrice;
	}

	public int getBusinessSeatPrice() {
		return businessSeatPrice;
	}

	public void setBusinessSeatPrice(int businessSeatPrice) {
		this.businessSeatPrice = businessSeatPrice;
	}

	public int getTotalEconomySeats() {
		return totalEconomySeats;
	}

	public void setTotalEconomySeats(int totalEconomySeats) {
		this.totalEconomySeats = totalEconomySeats;
	}

	public int getTotalbusinessSeats() {
		return totalbusinessSeats;
	}

	public void setTotalbusinessSeats(int totalbusinessSeats) {
		this.totalbusinessSeats = totalbusinessSeats;
	}

	public int getAvailableEconomySeats() {
		return availableEconomySeats;
	}

	public void setAvailableEconomySeats(int availableEconomySeats) {
		this.availableEconomySeats = availableEconomySeats;
	}

	public int getAvailableBusinessSeats() {
		return availableBusinessSeats;
	}

	public void setAvailableBusinessSeats(int availableBusinessSeats) {
		this.availableBusinessSeats = availableBusinessSeats;
	}
		
//
//	public Set<Booking> getBookings() {
//		return bookings;
//	}
//
//	public void setBookings(Set<Booking> bookings) {
//		this.bookings = bookings;
//	}

	public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", sourceLoc=" + sourceLoc
				+ ", destinationLoc=" + destinationLoc + ", departureDateTime=" + departureDateTime
				+ ", arrivalDateTime=" + arrivalDateTime + ", economySeatPrice=" + economySeatPrice
				+ ", businessSeatPrice=" + businessSeatPrice + ", totalEconomySeats=" + totalEconomySeats
				+ ", totalbusinessSeats=" + totalbusinessSeats + ", availableEconomySeats=" + availableEconomySeats
				+ ", availableBusinessSeats=" + availableBusinessSeats + "]";
	}

//	public Set<PassengerTicketBooked> getPassengerTicketBookeds() {
//		return passengerTicketBookeds;
//	}
//
//	public void setPassengerTicketBookeds(Set<PassengerTicketBooked> passengerTicketBookeds) {
//		this.passengerTicketBookeds = passengerTicketBookeds;
//	}

//	@Override
//	public String toString() {
//		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", sourceLoc=" + sourceLoc
//				+ ", destinationLoc=" + destinationLoc + ", departureDateTime=" + departureDateTime
//				+ ", arrivalDateTime=" + arrivalDateTime + ", economySeatPrice=" + economySeatPrice
//				+ ", businessSeatPrice=" + businessSeatPrice + ", totalEconomySeats=" + totalEconomySeats
//				+ ", totalbusinessSeats=" + totalbusinessSeats + ", availableEconomySeats=" + availableEconomySeats
//				+ ", availableBusinessSeats=" + availableBusinessSeats + ", bookings=" + bookings
//				+ ", passengerTicketBookeds=" + passengerTicketBookeds + "]";
//	}
	
	
	
}
