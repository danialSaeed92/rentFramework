/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the MIT License (MIT);
 */
package org.rentframework.core;

import java.sql.ResultSet;


public interface CheckoutRecordFacade {
	public int saveCheckoutRecord(CheckoutRecordEntry checkoutRecordEntry);

	public int removeCheckoutRecord(CheckoutRecordEntry checkoutRecordEntry);

	public int checkInRecord(CheckoutRecordEntry checkoutRecordEntry);

	public int undoCheckIn(CheckoutRecordEntry checkoutRecordEntry);

	public ResultSet getAllCheckoutRecordsByCustomer(int customerId, Class<?> tableName, Class<?> joinTableName);

	public ResultSet getAllCheckoutRecordsByCustomerAndUser(int customerId, int userId, Class<?> tableName);
	
	public ResultSet getAllCheckoutRecords(Class<?> tableName);
}
