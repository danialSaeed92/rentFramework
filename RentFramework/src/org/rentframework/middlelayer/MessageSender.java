/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the MIT License (MIT);
 */
package org.rentframework.middlelayer;

import org.rentframework.factory.Person;

/**
 * MessageSender Interface is the Implementor of Bridge Pattern hierarchy
 * ('Bridge/Implementor' interface) Clients can implement this interface for
 * sending text/Email.... messages
 * 
 * @author Fish
 * 
 * @version 1.0.0
 *
 */

public interface MessageSender {
	/**
	 * Method for sending message the implementation will be made by application
	 * user
	 * 
	 * @param body
	 *            this is an email body
	 * @param Person
	 *            to whom the email is sent
	 */
	public void sendMessage(String body, Person person);
}
