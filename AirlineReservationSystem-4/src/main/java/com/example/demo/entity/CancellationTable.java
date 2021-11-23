package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  
@Table(name="CancellationsTables")
public class CancellationTable
{
	@Id
	@GeneratedValue
	private int cancellationId;
	
	private LocalDate cancellationDate;
	
	private String cancellationReason;
	
	private String cancellationStatus;
	
	private double refundAmount;
	
	@OneToOne
	private TransactionTable transactionTable;
	
	
	public TransactionTable getTransactionTable() {
		return transactionTable;
	}

	public void setTransactionTable(TransactionTable transactionTable) {
		this.transactionTable = transactionTable;
	}

	public int getCancellationId() {
		return cancellationId;
	}

	public void setCancellationId(int cancellationId) {
		this.cancellationId = cancellationId;
	}

	public LocalDate getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(LocalDate cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public String getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public String getCancellationStatus() {
		return cancellationStatus;
	}

	public void setCancellationStatus(String cancellationStatus) {
		this.cancellationStatus = cancellationStatus;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	@Override
	public String toString() {
		return "CancellationTable [cancellationId=" + cancellationId + ", cancellationDate=" + cancellationDate
				+ ", cancellationReason=" + cancellationReason + ", cancellationStatus=" + cancellationStatus
				+ ", refundAmount=" + refundAmount + ", transactionTable=" + transactionTable + "]";
	}

	

	
	
	
}

