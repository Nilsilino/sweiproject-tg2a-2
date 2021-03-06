
package Mail;

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
	private static final String TEXT = "Dear User,\n\nHere is your verification code: THISCODE \n\nBest Regards,\nThe Activity Meter Team";
	private static final String FROM = "ActivityMeter2a2@gmail.com"; 
	private static final String host = "smtp.gmail.com";
	private static final String empty_text = "Dear User,\n\nSorry, this is not a valid Email. Therefore No link is sent.\n\nBest Regards,\nThe Activity Meter Team";
	private String to;
	Properties properties = System.getProperties();
	Session session;
	MimeMessage message;
	Transport transport;
	private String sending_text;
	

	public EMail(String to, int key) {
			checkEmail(to,key);
			sendEMail();
	}

	public boolean checkEmail(String to,int key) {
		this.to = to;
		if (to.endsWith("@hm.edu") || to.endsWith("@cpp.edu")) {
			sending_text = TEXT.replaceAll("THISCODE", Integer.toString(key));
			return true;
		} else {
			sending_text = empty_text;
			return false;

		}
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
            System.out.println(System.getenv("EMAIL_ADDRESS"));
            System.out.println(System.getenv("EMAIL_PASSWORD"));
            PasswordAuthentication passwordauthentication = new PasswordAuthentication(System.getenv("EMAIL_ADDRESS"), System.getenv("EMAIL_PASSWORD"));
            session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
            		@Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        System.out.println("Authenticating");
                        return passwordauthentication;
                        //return new PasswordAuthentication("ActivityMeter2a2@gmail.com", "SWEI2017");
                    }

                });
			message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(SUBJECT);
			message.setText(sending_text);
            transport = session.getTransport("smtp");
            Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "Sent Message succesfully";
	}


 }


