package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Flight;
import com.example.demo.exception.FlightNotFoundException;


	public interface AdminRepo {
		
		public boolean loginAdmin (Admin adminAccount);
		void addFlight (Flight newFlight);
		void deleteFlight(int flightId) throws FlightNotFoundException;
//		void deleteFlight(long flightId) throws FlightNotFoundException;		
	}

