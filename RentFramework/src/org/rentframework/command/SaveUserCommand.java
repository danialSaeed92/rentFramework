package org.rentframework.command;

import org.rentframework.core.SysUserFacade;
import org.rentframework.core.SysUserFacadeImpl;
import org.rentframework.command.Command;
import org.rentframework.middlelayer.SysUser;

public class SaveUserCommand implements Command {

	private SysUserFacade facade;
	private SysUser user;

	public SaveUserCommand(SysUser user) {
		this.user = user;
		this.facade = new SysUserFacadeImpl();
	}

	@Override
	public boolean execute() {
		int affectedRows = facade.saveSysUser(user);
		return affectedRows == 1 ? true : false;
	}

	@Override
	public boolean undo() {
		int affectedRows = facade.removeSysUser(user);
		return affectedRows == 1 ? true : false;
	}

}

