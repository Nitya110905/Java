package Service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email_otp {
	public void sendMail(String emailid, int num) {
		final String username = "Otp-EmailId";
		final String password = "PasswordKey";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.debug", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
//		587
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		System.out.println("session complete");
		try {
			System.out.println("1");
			Message message = new MimeMessage(session);
			System.out.println("2");
			message.setFrom(new InternetAddress(username));
			System.out.println("3");
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailid));// to mail address.
			System.out.println("4");
			message.setSubject("Forgot Password");
			message.setText("Here is your OTP to change password : " + num);
			System.out.println("5");
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
