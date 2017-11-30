package Mail;

import static org.junit.Assert.*;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

import org.junit.Test;

public class EMailTest {

	@Test
	public void testSendEmail() {
		EMail mail = new EMail("ActivityMeter2a2@gmail.com", 12345);
		assertEquals(mail.sendEMail(), "Sent Message succesfully");
	}
	
	@Test 
	public void testCheckEmail() {
		EMail mail = new EMail("ActivityMeter2a2@gmail.com", 12345);
		assertFalse(mail.checkEmail("ActivityMeter2a2@gmail.com"));
	}
	
	/*@Test(expected = SendFailedException.class) 
	public void testMessagingException() {
		EMail mail = new EMail("ActivityMeter2a2");
	}
	*/
}
