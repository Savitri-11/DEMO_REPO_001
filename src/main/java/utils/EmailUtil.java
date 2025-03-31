package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Part;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailUtil {

	public static void sendEmail()
			throws FileNotFoundException, IOException {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		props.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties"));

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("fromEmail"), props.getProperty("appPassword"));
			}
		});

		session.setDebug(true);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(props.getProperty("fromEmail")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(props.getProperty("toEmail")));
			message.setSubject(props.getProperty("subject"));

			// Email Body Part
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText(props.getProperty("body"));

			// Attachment Part
			MimeBodyPart attachmentPart = new MimeBodyPart();
			String filePath = System.getProperty("user.dir") + "/reports/htmlreport.html";

			System.out.println("ATTACHED FILE =" + filePath);

			attachmentPart.attachFile(new File(filePath));

			// Combine body and attachment parts
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);

			// Send email
			Transport.send(message);

			System.out.println("Email sent successfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}