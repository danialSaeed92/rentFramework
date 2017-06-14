
package org.rentframework.middlelayer;

import java.util.List;

import org.rentframework.core.CheckoutRecordEntry;


public abstract class TransactionManager {
	public final void proceedTransaction(List<CheckoutRecordEntry> checkoutRecordEntries, Class<?> productClass) {
		List<CheckoutRecordEntry> rentalFeeFine = calculateRentalFeeOrOverdueFine(checkoutRecordEntries, productClass);
		processCheckoutRecord(checkoutRecordEntries);
		try {
			sendNotification(checkoutRecordEntries, productClass);
		} catch (Exception ex) {

		}

		printBill(rentalFeeFine);
	}

	protected abstract List<CheckoutRecordEntry> calculateRentalFeeOrOverdueFine(
			List<CheckoutRecordEntry> checkoutRecordEntries, Class<?> productClass);

	protected abstract void processCheckoutRecord(List<CheckoutRecordEntry> checkoutRecordEntries);
	protected abstract void sendNotification(List<CheckoutRecordEntry> checkoutRecordEntries, Class<?> productClass);
	protected void printBill(List<CheckoutRecordEntry> checkoutRecordEntries) {
		StringBuilder builder = new StringBuilder();

		builder.append("\n\n---------------------------------------\n");
		builder.append("========Rental System Bill=========\n");
		for (CheckoutRecordEntry checkoutRecordEntry : checkoutRecordEntries) {
			builder.append("Your total Rental Fee is : " + checkoutRecordEntry.getRentalFee());
			builder.append("\nYour total Rental Fine is : " + checkoutRecordEntry.getRentalFine());
		}
		builder.append("\n---------------------------------------\n");

		System.out.println(builder.toString());
	}
}
