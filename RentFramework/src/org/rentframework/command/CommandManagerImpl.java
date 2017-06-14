package org.rentframework.command;

import java.util.List;
import java.util.Stack;

import org.rentframework.core.CheckoutRecordEntry;
import org.rentframework.core.Customer;
import org.rentframework.core.Product;
import org.rentframework.middlelayer.SysUser;

public class CommandManagerImpl implements CommandManager {

	private Stack<Command> commands = new Stack<Command>();
	private Command currentCommand = null;

	@Override
	public boolean saveCustomer(Customer customer) {

		currentCommand = new SaveCustomerCommand(customer);

		if (currentCommand.execute()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveProduct(Product product) {

		currentCommand = new SaveProductCommand(product);
		if (currentCommand.execute()) {
			// commands.push(currentCommand);
			return true;
		}
		return false;
	}

	@Override
	public boolean saveSysUser(SysUser user) {

		currentCommand = new SaveUserCommand(user);
		if (currentCommand.execute()) {
			return true;
		}

		return false;
	}

	@Override
	public boolean saveCheckoutRecords(List<CheckoutRecordEntry> checkoutRecordEntries) {

		commands.clear();
		for (CheckoutRecordEntry entry : checkoutRecordEntries) {
			currentCommand = new CheckoutCommand(entry);
			if (currentCommand.execute()) {
				commands.push(currentCommand);
				System.out.println("executed");
			} else {
				System.out.println("not executed");
				while (commands.size() > 0) {
					currentCommand = commands.pop();
					currentCommand.undo();

				}
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean checkBackRecordsIn(List<CheckoutRecordEntry> checkInEntries) {

		commands.clear();
		for (CheckoutRecordEntry entry : checkInEntries) {
			currentCommand = new CheckinCommand(entry);
			System.out.println("before execution");
			if (currentCommand.execute()) {
				System.out.println("executing");
				commands.push(currentCommand);
			} else {
				while (commands.size() > 0) {
					currentCommand = commands.pop();
					currentCommand.undo();

				}
				return false;
			}
		}

		return true;
	}
}
