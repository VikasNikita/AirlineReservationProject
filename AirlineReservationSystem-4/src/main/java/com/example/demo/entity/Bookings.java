package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BookingsTab")
public class Bookings
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BOOKINGID")
	private int bookingId;
	
	private int economySeatsBooked;
	
	private int businessSeatsBooked;
	
	private LocalDate bookingDate;
	
	private String BookingStatus;
	
	private String JourneyType;
	
	private int totalCost;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToOne
	private TransactionTable transactionTable;
	
	@ManyToOne
	@JoinColumn(name="Flight_ID")
	Flight flight;
	
	
	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Bookings( int economySeatsBooked, int businessSeatsBooked, LocalDate bookingDate,
			String bookingStatus, String journeyType, int totalCost,User user) {
		super();
		this.bookingId = bookingId;
		this.economySeatsBooked = economySeatsBooked;
		this.businessSeatsBooked = businessSeatsBooked;
		this.bookingDate = bookingDate;
		BookingStatus = bookingStatus;
		JourneyType = journeyType;
		this.totalCost = totalCost;
		this.user = user;
	}

	
	public Bookings( int economySeatsBooked, int businessSeatsBooked, LocalDate bookingDate,
			String bookingStatus, String journeyType, int totalCost,Flight flight) {
		super();
		this.bookingId = bookingId;
		this.economySeatsBooked = economySeatsBooked;
		this.businessSeatsBooked = businessSeatsBooked;
		this.bookingDate = bookingDate;
		BookingStatus = bookingStatus;
		JourneyType = journeyType;
		this.totalCost = totalCost;
		this.flight = flight;
	}



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public TransactionTable getTransactionTable() {
		return transactionTable;
	}


	public void setTransactionTable(TransactionTable transactionTable) {
		this.transactionTable = transactionTable;
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public int getEconomySeatsBooked() {
		return economySeatsBooked;
	}


	public void setEconomySeatsBooked(int economySeatsBooked) {
		this.economySeatsBooked = economySeatsBooked;
	}


	public int getBusinessSeatsBooked() {
		return businessSeatsBooked;
	}


	public void setBusinessSeatsBooked(int businessSeatsBooked) {
		this.businessSeatsBooked = businessSeatsBooked;
	}


	


	public LocalDate getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}


	public String getBookingStatus() {
		return BookingStatus;
	}


	public void setBookingStatus(String bookingStatus) {
		BookingStatus = bookingStatus;
	}


	public String getJourneyType() {
		return JourneyType;
	}


	public void setJourneyType(String journeyType) {
		JourneyType = journeyType;
	}


	public int getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}





	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", economySeatsBooked=" + economySeatsBooked
				+ ", businessSeatsBooked=" + businessSeatsBooked + ", bookingDate=" + bookingDate + ", BookingStatus="
				+ BookingStatus + ", JourneyType=" + JourneyType + ", totalCost=" + totalCost + ", user=" + user
				+ ", transactionTable=" + transactionTable + ", flight=" + flight + "]";
	}


//	@Override
//	public String toString() {
//		return "Bookings [bookingId=" + bookingId + ", economySeatsBooked=" + economySeatsBooked
//				+ ", businessSeatsBooked=" + businessSeatsBooked + ", bookingDate=" + bookingDate + ", BookingStatus="
//				+ BookingStatus + ", JourneyType=" + JourneyType + ", totalCost=" + totalCost + ", transactionTable="
//				+ transactionTable + ", flight=" + flight + "]";
//	}
//
	
	




	
	
}

