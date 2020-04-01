package model_mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
//
	public static void sendEmail(String to, String form, String subject, String body, boolean bodyIsHTML) throws MessagingException {
		
		//1- lay mail session
		Properties props = new Properties();
		
		props.put("mail.transport.protocol", "smt");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		//2- tao thong bao
		Message meesenger = new MimeMessage(session);
		//throw exception
		meesenger.setSubject(subject);
		if(bodyIsHTML) {
			meesenger.setContent(body,"text/html");
		}else {
			meesenger.setText(body);
		}
		
		//3 - address messenger
		Address fromAddress = new InternetAddress(form);
		Address toAddresss = new InternetAddress(to);
		meesenger.setFrom(fromAddress);
		meesenger.setRecipient(Message.RecipientType.TO, toAddresss);

		//4 - gui di
		Transport.send(meesenger);
				

	}
	public static boolean sendMail(String to, String subject, String text) {
	 Properties props = new Properties();
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.put("mail.smtp.port", "587");
     Session session = Session.getInstance(props,
             new javax.mail.Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication("dangvanda.itnlu@gmail.com", "Da10a21998321123");
         }
     });
     try {
         Message message = new MimeMessage(session);
         message.setHeader("Content-Type", "text/plain; charset=UTF-8");
         message.setFrom(new InternetAddress("dangvanda.itnlu@gmail.com"));
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
         message.setSubject(subject);
         message.setText(text);
         Transport.send(message);
     } catch (MessagingException e) {
         return false;
     }
     return true;
	}
}
