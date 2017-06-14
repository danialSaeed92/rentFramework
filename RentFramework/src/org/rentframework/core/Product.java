/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the MIT License (MIT);
 */
package org.rentframework.core;


public interface Product {
	public void setProductId(int productId);

	public int getProductId();
	public void setProductName(String productName);

	public String getProductName();
	public void setRentalFeePerDay(double rentalFee);

	public double getRentalFeePerDay();
	public void setOverDueFinePerDay(double rentalFee);
	public double getOverDueFinePerDay();

}
