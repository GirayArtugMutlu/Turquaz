/*
 * Created on Apr 5, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author onsel
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Emailer
{
	 /**
	  * Send a single email.
	  */
	  public static void sendEmail( String aFromEmailAddr,
	                         String aToEmailAddr,
	                         String aSubject,
	                         String aBody ) {

	    //Here, no Authenticator argument is used (it is null).
	    //Authenticators are used to prompt the user for user
	    //name and password.
	  	
	  	Properties fMailServerConfig = new Properties();
	  	fMailServerConfig.setProperty("mail.host","www.turquaz.com");
		fMailServerConfig.setProperty("mail.from","error@turquaz.com");
	  	
	    Session session = Session.getDefaultInstance( fMailServerConfig, null );

	    MimeMessage message = new MimeMessage( session );

	    try {
	      //the "from" address may be set in code, or set in the
	      //config file under "mail.from" ; here, the latter style is used
	      //message.setFrom( new InternetAddress(aFromEmailAddr) );
	      message.addRecipient(Message.RecipientType.TO, new InternetAddress(aToEmailAddr));
	      message.setSubject( aSubject );
	      message.setText( aBody );

	      Transport.send( message );
	    }
	    catch (MessagingException ex){
	    	ex.printStackTrace();
	      System.err.println("Cannot send email. " + ex);
	    }
	  }
}
