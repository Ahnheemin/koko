package rt.koko.service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;

public class SMTPAuthenticator extends Authenticator {

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new javax.mail.PasswordAuthentication(
				"koko00055@naver.com","zhtmxk004");
	}
	
	
}
