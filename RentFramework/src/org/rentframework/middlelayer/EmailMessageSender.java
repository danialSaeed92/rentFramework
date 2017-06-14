/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the MIT License (MIT);
 */
package org.rentframework.middlelayer;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.rentframework.factory.Person;
import org.rentframework.utils.ConfigProperties;
import org.rentframework.utils.ConfigPropertiesImpl;



/**
 * This @{EmailMessageSender} used to send notification email to the user It
 * implements @{MessageSender} ('Bridge/Implementor') interface
 * 
 * @author Fish
 * @version 1.0.0
 *
 */
public class EmailMessageSender implements MessageSender {

	private ConfigProperties config;

	public EmailMessageSender() {
		this.config = new ConfigPropertiesImpl("mail.properties");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cs525.project.fujframework.middleware.MessageSender#sendMessage(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public void sendMessage(String body, Person person) {
		final String username = config.readProperty("username");
		final String password = config.readProperty("password");
		final String to = person.getEmail();

		Properties props = new Properties();
		props.put(config.readProperty("user"), username);
		props.put(config.readProperty("auth"), "true");
		props.put(config.readProperty("starttls"), "true");
		props.put(config.readProperty("portname"), config.readProperty("port"));
		props.put(config.readProperty("enablessl"), "true");
		props.put(config.readProperty("hostname"), config.readProperty("host"));

		props.setProperty(config.readProperty("socketfactoryname"), config.readProperty("socketfactory"));
		props.setProperty(config.readProperty("fallback"), "false");
		props.setProperty(config.readProperty("smtpportname"), config.readProperty("smtpport"));
		props.setProperty(config.readProperty("socketfacprtname"), config.readProperty("socketfacport"));

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {

			javax.mail.Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Item(s) Checkout Notification");
			message.setText(body);

			Transport.send(message);

			System.out.println("Email Successfully Sent!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
