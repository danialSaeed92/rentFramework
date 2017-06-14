/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the MIT License (MIT);
 */
package org.rentframework.core;

import java.sql.ResultSet;

import org.rentframework.dbcore.DBHandler;
import org.rentframework.dbcore.DBHandlerImpl;
import org.rentframework.middlelayer.SysUser;
import org.rentframework.utils.DbHelper;




public class SysUserFacadeImpl implements SysUserFacade {
	private DBHandler dbaction;
	StringBuilder queryBuilder;
	public SysUserFacadeImpl() {
		this.dbaction = new DBHandlerImpl();
	}
	@Override
	public int saveSysUser(SysUser sysUser) {
		if (sysUser.getSysuserId() > 0)
			return this.dbaction.update(DbHelper.getUpdateQuery(sysUser));
		return this.dbaction.Create(DbHelper.getInsertQuery(sysUser));
	}
	@Override
	public int removeSysUser(SysUser sysUser) {
		queryBuilder = new StringBuilder();
		queryBuilder.append("DELETE FROM sysuser WHERE sysUserId=" + sysUser.getPersonId());
		return this.dbaction.delete(queryBuilder.toString());
	}

	@Override
	public ResultSet getAllUsers(Class<?> tableName) {
		queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT * FROM " + tableName.getSimpleName());
		return this.dbaction.read(queryBuilder.toString());
	}

	@Override
	public ResultSet getUserByUserNameAndPassword(String userName, String password, Class<?> userTable) {
		
		queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT * FROM " + userTable.getSimpleName() + " WHERE username='" + userName +"' AND password='" + password +"';");
		return this.dbaction.read(queryBuilder.toString());
	
	}

}
