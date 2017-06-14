/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the MIT License (MIT);
 */
package org.rentframework.core;

import java.time.LocalDate;


public class CheckoutRecordEntry {
	private int checkoutRecordEntryId;
	private int productRefId;
	private int customerRefId;
	private int personRefId;
	private int quantity;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private LocalDate returnedDate;
	private boolean isReturned;
	private double rentalFee;
	private double rentalFine;

	public int getProductRefId() {
		return productRefId;
	}
	public void setProductRefId(int productRefId) {
		this.productRefId = productRefId;
	}
	public int getCustomerRefId() {
		return customerRefId;
	}
	public void setCustomerRefId(int customerRefId) {
		this.customerRefId = customerRefId;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	public double getRentalFee() {
		return rentalFee;
	}
	public void setRentalFee(double rentalFee) {
		this.rentalFee = rentalFee;
	}
	public double getRentalFine() {
		return rentalFine;
	}

	public void setRentalFine(double rentalFine) {
		this.rentalFine = rentalFine;
	}
	public int getCheckoutRecordEntryId() {
		return checkoutRecordEntryId;
	}
	public void setCheckoutRecordEntryId(int checkoutRecordEntryId) {
		this.checkoutRecordEntryId = checkoutRecordEntryId;
	}

	public int getPersonRefId() {
		return personRefId;
	}

	public void setPersonRefId(int personRefId) {
		this.personRefId = personRefId;
	}

}
