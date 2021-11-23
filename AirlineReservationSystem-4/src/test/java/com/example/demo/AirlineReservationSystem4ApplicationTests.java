package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Bookings;
import com.example.demo.entity.CancellationTable;
import com.example.demo.entity.Flight;
import com.example.demo.entity.PassengerTable;
import com.example.demo.entity.TransactionTable;
import com.example.demo.entity.User;
import com.example.demo.repo.AdminRepoImple;

@SpringBootTest
class AirlineReservationSystem4ApplicationTests
{
	

	@Test
	public void insertTransaction() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 

		System.out.println("Entity Manager Factory : "+entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M

		System.out.println("Entity Manager : "+entityManager);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
			TransactionTable transactionTable = new TransactionTable();
			transactionTable.setTransactionAmount(120000);
			transactionTable.setTransactionMode("Online");
			transactionTable.setTransactionStatus("succ");
			transactionTable.setTransactionType("Phonepay");
			entityManager.persist(transactionTable); 
		transaction.commit();
	}
	
	@Test
	public void insertCancellation() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 

		System.out.println("Entity Manager Factory : "+entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		System.out.println("Entity Manager : "+entityManager);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
			CancellationTable cancellationTable = new CancellationTable(); //new/blank entity object 
			cancellationTable.setCancellationReason("Some issue to cancellation ");
			cancellationTable.setCancellationDate(LocalDate.of(2021, 12, 25));
			cancellationTable.setCancellationStatus("active");
			cancellationTable.setRefundAmount(1200.0);
			

			entityManager.persist(cancellationTable); //generate the insert query for us 
		transaction.commit();
	}


	
	@Test
	public void insertFlightWithBookingsCascadeWay() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 
		
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("Entity Manager : "+entityManager);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Flight flight = new Flight();

//		flight.setFlightId(43);
		flight.setEconomySeatPrice(1200);
		flight.setBusinessSeatPrice(1300);
		flight.setSourceLoc("Goa");
		flight.setDestinationLoc("Mumbai");
		flight.setArrivalDateTime(LocalDateTime.of(2020, 10, 31, 12, 30,34));
		flight.setDepartureDateTime(LocalDateTime.of(2021, 1, 12, 12, 12,30));
		flight.setAvailableEconomySeats(12);
		flight.setAvailableBusinessSeats(13);
		flight.setTotalbusinessSeats(30);
		flight.setTotalEconomySeats(30);
		LocalDate localDate=LocalDate.now();

			Set<Bookings> bookingSet = new HashSet<Bookings>();//blank set
//			Bookings bookingObj1=new Bookings(1,2,localDate,"succ","Within country",1600,flight);
			Bookings bookingObj1=new Bookings( 2, 2, localDate, "succ","outside country", 12000, flight);
			bookingSet.add(bookingObj1);
			flight.setBookings(bookingSet); //assign this new set to the dept
			
			entityManager.persist(flight);
			
			
		transaction.commit();
	}
	/*
	@Test
	public void insertFlightWithPassengerTicketBookedCascadeWay() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 
		
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M
		
		System.out.println("Entity Manager : "+entityManager);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Flight flight = new Flight();

//		flight.setFlightId(43);
		flight.setEconomySeatPrice(1200);
		flight.setBusinessSeatPrice(1300);
		flight.setSourceLoc("Goa");
		flight.setDestinationLoc("Mumbai");
		flight.setArrivalDateTime(LocalDateTime.of(2020, 10, 31, 12, 30,34));
		flight.setDepartureDateTime(LocalDateTime.of(2021, 1, 12, 12, 12,30));
		flight.setAvailableEconomySeats(12);
		flight.setAvailableBusinessSeats(13);
		flight.setTotalbusinessSeats(30);
		flight.setTotalEconomySeats(30);
		LocalDate localDate=LocalDate.now();

			Set<PassengerTicketBooked> passengerTicketBookeds = new HashSet<PassengerTicketBooked>();//blank set
			PassengerTicketBooked passengerTicketBooked=new PassengerTicketBooked( flight);
//			Bookings bookingObj1=new Bookings(11,1,2,localDate,"succ","Within country",1600,flight);
//				Employee empObj1 = new Employee(104,"Amar",3000.0f,dept);
//				Employee empObj2 = new Employee(105,"Akbar",4000.0f,dept);
//				Employee empObj3 = new Employee(106,"Anthony",5000.0f,dept);
			
			
			passengerTicketBookeds.add(passengerTicketBooked);
			flight.setPassengerTicketBookeds(passengerTicketBookeds); //assign this new set to the dept
			
			entityManager.persist(flight);
			
			
		transaction.commit();
	}
	
	*/
	@Test
	void assignExistingTransactionToExistingCancellation()
	{
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 
		
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("Entity Manager : "+entityManager);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
	
		
				TransactionTable transactionTable 	  = entityManager.find(TransactionTable.class, 1);
				CancellationTable cancellation = entityManager.find(CancellationTable.class, 2);
				
				transactionTable.setCancellationTable(cancellation);// are we setting the FK?
				cancellation.setTransactionTable(transactionTable); // are we setting the FK?
				
				entityManager.merge(cancellation);
				entityManager.merge(transactionTable);
				
		transaction.commit();		
		
	}
	
	@Test
	void assignExistingTransactionToExistingBooking()
	{
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA");  
		
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M
		
		System.out.println("Entity Manager : "+entityManager);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
	
		
				TransactionTable transactionTable 	  = entityManager.find(TransactionTable.class, 1);
				Bookings bookings = entityManager.find(Bookings.class, 3);
				
				transactionTable.setBookings(bookings);// are we setting the FK?
				bookings.setTransactionTable(transactionTable); // are we setting the FK?
				
				entityManager.merge(bookings);
				entityManager.merge(transactionTable);
				
		transaction.commit();		
		
	}
	
	@Test
	public void insertBookingWithUserCascadeWay() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 
		
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M
		
		System.out.println("Entity Manager : "+entityManager);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		User user = new User();


		user.setFirstName("Abcd");
		user.setLastName("xyz");
		user.setEmailId("abcd@123gmail.com");
		user.setMobNumber(9172633456L);
		user.setPassward("890");
		user.setDob(LocalDate.of(1997, 12, 31));
	
			LocalDate localDate1=LocalDate.of(2020, 5, 8);
			Set<Bookings> bookingSet2 = new HashSet<Bookings>();
//			Bookings bookingObj1=new Bookings(1,2,localDate1,"succ","Within country",1600,transaction);
			Bookings bookingObj2=new Bookings( 2, 2, localDate1,"succ","with country", 1300, user);
			bookingSet2.add(bookingObj2);
			user.setBookings(bookingSet2); 
			
			entityManager.persist(user);
			
			
		transaction.commit();
	}
	@Test
	public void insertUserWithPassengerTableCascadeWay() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 
		
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M
		
		System.out.println("Entity Manager : "+entityManager);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		User user = new User();


		user.setFirstName("Nikita");
		user.setLastName("Bhavsar");
		user.setEmailId("niki@123gmail.com");
		user.setMobNumber(9172633456L);
		user.setPassward("1234");
		user.setDob(LocalDate.of(1997, 12, 31));
	
			LocalDate localDate1=LocalDate.of(1997, 5, 8);
//			Set<Bookings> bookingSet2 = new HashSet<Bookings>();
////			Bookings bookingObj1=new Bookings(1,2,localDate1,"succ","Within country",1600,transaction);
//			Bookings bookingObj2=new Bookings( 2, 2, localDate1,"succ","with country", 1300, user);
//			bookingSet2.add(bookingObj2);
//			user.setBookings(bookingSet2); 
			
		Set<PassengerTable> passengerTablesSet=new HashSet<PassengerTable>();
		PassengerTable passengerObj=new PassengerTable("Nikita", "Bhavsar","female", localDate1, user);
		passengerTablesSet.add(passengerObj);
		user.setPassengerTables(passengerTablesSet);
			entityManager.persist(user);
			
			
		transaction.commit();
	}
}