/**
 * 
 */
package hello;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author hm-nwimmer
 *
 */
public class EMail {

	private static final String SUBJECT = "Your personal link to Create/Change ur activity";
	private static final String TEXT = "This is an auto-generated E-Mail. Please Click on the following link to create/edit an activity: localhost:8080/greetings";
	private static final String FROM = "ActivityMeter2a2@gmail.com"; 
	private static final String host = "smtp.gmail.com";
	private static final String TO = "[I@7ea987ac";
	private final String to;
	private byte[] array;
	Properties properties = System.getProperties();
	Session session;
	MimeMessage message;
	Transport transport;
	/**
	 * 
	 */
	public EMail(String to) {
		// TODO Auto-generated constructor stub
		this.to = to;
	}


	
	String sendEMail () {

        try {		
            properties = new Properties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.socketFactory.port", "465");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            session = Session.getInstance(properties, new javax.mail.Authenticator(){

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        System.out.println("Authenticating");
                        return new PasswordAuthentication(FROM, TO);
                    }

                });
			message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(SUBJECT);
			message.setText(TEXT);
            transport = session.getTransport("smtp");
            Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "Sent Message succesfully";
	}

	public byte[] asciiConverter(String message) {
		try {
			array = message.getBytes("US-ASCII");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	public String asciiString (byte[] array) {
		String result = "";
		for (byte b : array) {
			result += Byte.toString(b);
		}
		return result;	
	}
 }
