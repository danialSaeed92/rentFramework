package org.rentframework.command;

import org.rentframework.core.CheckoutRecordEntry;
import org.rentframework.core.CheckoutRecordFacade;
import org.rentframework.core.CheckoutRecordProtectionProxy;

public class CheckinCommand implements Command {

	private CheckoutRecordFacade facade;
	private CheckoutRecordEntry checkoutRecordEntry;

	public CheckinCommand(CheckoutRecordEntry checkoutRecordEntry) {
		this.facade = new CheckoutRecordProtectionProxy();
		this.checkoutRecordEntry = checkoutRecordEntry;
	}

	@Override
	public boolean execute() {
		int affectedRows = facade.checkInRecord(checkoutRecordEntry);
		return affectedRows == 1 ? true : false;
	}

	@Override
	public boolean undo() {
		int affectedRows = facade.undoCheckIn(checkoutRecordEntry);
		return affectedRows == 1 ? true : false;
	}

}
