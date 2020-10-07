package com.digitallbrarymanagementsystem.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IssueDump {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IID;
	private long UID;
	private long BID;
	private LocalDate issueDate;
	private int period;
	private LocalDate returnDate;
	private double fine;

	public long getIID() {
		return IID;
	}

	public void setIID(long iID) {
		IID = iID;

	}

	public long getUID() {
		return UID;
	}

	public void setUID(long uID) {
		UID = uID;
	}

	public long getBID() {
		return BID;
	}

	public void setBID(long bID) {
		BID = bID;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

}
