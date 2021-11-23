package com.example.demo.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="u")
public class User 
{
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private int userId;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String passward;
	
	private LocalDate dob;
	
	private  long mobNumber;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private Set<PassengerTable> passengerTables=new HashSet<PassengerTable>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private Set<Bookings> bookings=new HashSet<Bookings>();

	
	public Set<PassengerTable> getPassengerTables() {
		return passengerTables;
	}

	public void setPassengerTables(Set<PassengerTable> passengerTables) {
		this.passengerTables = passengerTables;
	}

	public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(long mobNumber) {
		this.mobNumber = mobNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", passward=" + passward + ", dob=" + dob + ", mobNumber=" + mobNumber + ", bookings=" + bookings
				+ "]";
	}

	
	
	
}
