package org.rentframework.command;

import java.util.List;

import org.rentframework.core.CheckoutRecordEntry;
import org.rentframework.core.Customer;
import org.rentframework.core.Product;
import org.rentframework.middlelayer.SysUser;

public interface CommandManager {

	
	boolean saveCustomer(Customer customer);

	boolean saveProduct(Product product);

	boolean saveSysUser(SysUser user);

	boolean saveCheckoutRecords(List<CheckoutRecordEntry> checkoutRecordEntries);

	boolean checkBackRecordsIn(List<CheckoutRecordEntry> checkInEntries);
}
