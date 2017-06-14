package org.rentframework.command;

import org.rentframework.core.CheckoutRecordEntry;
import org.rentframework.core.CheckoutRecordFacade;
import org.rentframework.core.CheckoutRecordProtectionProxy;
import org.rentframework.command.Command;

public class CheckoutCommand implements Command {

	private CheckoutRecordFacade facade;
	private CheckoutRecordEntry checkoutRecordEntry;

	public CheckoutCommand(CheckoutRecordEntry checkoutRecordEntry) {
		this.facade = new CheckoutRecordProtectionProxy();
		this.checkoutRecordEntry = checkoutRecordEntry;
	}

	@Override
	public boolean execute() {

		int affectedRows = facade.saveCheckoutRecord(checkoutRecordEntry);
		return affectedRows == 1 ? true : false;
	}

	@Override
	public boolean undo() {

		int affectedRows = facade.removeCheckoutRecord(checkoutRecordEntry);
		return affectedRows == 1 ? true : false;
	}

}

