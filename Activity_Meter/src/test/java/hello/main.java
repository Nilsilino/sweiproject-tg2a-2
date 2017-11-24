package hello;

public class main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EMail mail = new EMail("nils.wimmer@hotmail.com");
		// System.out.println(mail.sendEMail());
		
		byte[] array = mail.asciiConverter("SWEI2017");
		System.out.println(mail.asciiString(array));
	}

}
