package com.example.demo.repo;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Flight;
import com.example.demo.exception.FlightNotFoundException;

@Repository
public class AdminRepoImple extends BaseRepository implements AdminRepo
{

	@Override
	public boolean loginAdmin(Admin adminAccount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addFlight(Flight newFlight) {
		super.persist(newFlight); // invoking the dummy persist of the super class
		System.out.println("department inserted...");
		
	}

	@Override
	public void deleteFlight(int flightId) throws FlightNotFoundException {
		System.out.println("DepartmentRepositoryImpl : Deleting department");
		super.remove(Flight.class, flightId);
		
	}
/*
 
	@Transactional
	public boolean loginAdmin(Admin adminAccount) 
	{
		return false;
	}

	
	@Transactional
	public void addFlight(Flight newFlight) {
		super.persist(newFlight);
		System.out.println("Flight Added Successfully.");

		
	}


	



	


	
		@Transactional
	public void deleteFlight(long flightId) throws FlightNotFoundException 
		{
			// TODO Auto-generated method stub
			EntityManager entityManager = getEntityManager();
			Flight foundflight = entityManager.find(Flight.class, flightId); //find it 
			if(foundflight!=null)
				entityManager.remove(foundflight); // based on PK
			else
				throw new FlightNotFoundException("Employee Not Found : "+flightId);
			System.out.println("EntityManager: employee removed.. ");

		}


		@Override
		public void deleteFlight(int flightId) throws FlightNotFoundException {
			// TODO Auto-generated method stub
			
		}


	*/	

		
	

}
