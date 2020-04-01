package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import modelConnection.DatabaseConnection;

public class SendMail {
	public static boolean sendMail(String to, String subject, String text) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// Mail máy chủ gửi đến người yêu cầu
				return new PasswordAuthentication("thanhdien25598@gmail.com", "dien1998");
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			message.setFrom(new InternetAddress("thanhdien25598@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean forgotPass(String email) {

		String sql = "SELECT pass FROM userpass where username like ?";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, email);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String result = rs.getString("pass");
				SendMail.sendMail(email, "Change Passwword", "Mật khẩu của bạn là: " + result);
				return true;

			}
			pr.close();
			conn.close();

		} catch (

		Exception e) {
			e.printStackTrace();
			System.out.println("Mail không đúng hoặc không tồn tại");
		}
		return false;
	}

	public static void main(String[] args) {
	//	System.out.println(sendMail("thanhdien25598@gmail.com", "Test Mail", "hihi"));
		System.out.println(forgotPass("16130283@st.hcmuaf.edu.vn"));
	}
}
