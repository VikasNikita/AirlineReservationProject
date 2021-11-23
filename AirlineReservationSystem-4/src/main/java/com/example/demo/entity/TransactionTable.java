package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="transactionsTables")
public class TransactionTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trannsactionId;
	
	private String transactionType;
	
	private String transactionMode;
	
	private float transactionAmount;
	
	private String transactionStatus;


	@OneToOne(cascade = CascadeType.ALL,mappedBy = "transactionTable")
	private CancellationTable cancellationTable;
	
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "transactionTable")
	private Bookings bookings;
	

	public CancellationTable getCancellationTable() {
		return cancellationTable;
	}

	public void setCancellationTable(CancellationTable cancellationTable) {
		this.cancellationTable = cancellationTable;
	}

	public Bookings getBookings() {
		return bookings;
	}

	public void setBookings(Bookings bookings) {
		this.bookings = bookings;
	}

	public int getTrannsactionId() {
		return trannsactionId;
	}

	public void setTrannsactionId(int trannsactionId) {
		this.trannsactionId = trannsactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	@Override
	public String toString() {
		return "TransactionTable [trannsactionId=" + trannsactionId + ", transactionType=" + transactionType
				+ ", transactionMode=" + transactionMode + ", transactionAmount=" + transactionAmount
				+ ", transactionStatus=" + transactionStatus + ", bookings=" + bookings + "]";
	}
	
	
	
	
	
	
	
	
}
