/**
 * 
 */
package org.rentframework.middlelayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.rentframework.command.CommandManager;
import org.rentframework.command.CommandManagerImpl;
import org.rentframework.core.CheckoutRecordEntry;
import org.rentframework.core.Customer;
import org.rentframework.core.CustomerFacade;
import org.rentframework.core.CustomerFacadeImpl;
import org.rentframework.core.ProductFacade;
import org.rentframework.core.ProductFacadeImpl;
import org.rentframework.strategy.EmailNotificationStrategy;


public class CheckinTransactionManager extends TransactionManager {
	private CommandManager command;
	private ProductFacade productFacade;
	private CustomerFacade customerFacade;
	private Notifier notifier;

	
	public CheckinTransactionManager() {
		command = new CommandManagerImpl();
		productFacade = new ProductFacadeImpl();
		customerFacade = new CustomerFacadeImpl();
		notifier = new Notifier(new EmailNotificationStrategy());
	}

	@Override
	protected List<CheckoutRecordEntry> calculateRentalFeeOrOverdueFine(List<CheckoutRecordEntry> checkoutRecordEntries,
			Class<?> productClass) {
		return checkoutRecordEntries;
	}

	@Override
	protected void processCheckoutRecord(List<CheckoutRecordEntry> checkoutRecordEntries) {
		command.checkBackRecordsIn(checkoutRecordEntries);
	}

	@Override
	protected void sendNotification(List<CheckoutRecordEntry> checkoutRecordEntries, Class<?> prodClass) {
		double totalFine = 0;
		int customerId = checkoutRecordEntries.get(0).getCustomerRefId();
		ResultSet rs = customerFacade.getCustomerById(customerId);
		Customer customer = new Customer();
		try {
			while (rs.next()) {

				customer.setEmail(rs.getString("email"));
				customer.setPersonId(rs.getInt("customerId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (CheckoutRecordEntry checkoutRecordEntry : checkoutRecordEntries) {
			totalFine += checkoutRecordEntry.getRentalFine();
		}

		StringBuilder message = new StringBuilder();
		message.append("Your total fine for the rented items is " + totalFine);

		notifier.notifyPerson(message.toString(), customer);
	}

}
