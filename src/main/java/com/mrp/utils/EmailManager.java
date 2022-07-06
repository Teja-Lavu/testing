package com.mrp.utils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.File;
import java.util.Properties;

public class EmailManager {

	static String usenName = "qadevelopment@marketresourcepartners.com";
	static String password = "%yMqPBS9$f";

	public static void sendEmail() throws MessagingException {
		GenericMethods.logInfo("Send Email Start");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.user", usenName);
		props.put("mail.password", password);

		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usenName, password);
			}
		};

		Session session = Session.getInstance(props, auth);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(usenName));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("rmettu@mrpfd.com")); // like
		// inzi769@gmail.com
		message.setSubject("Automation Report");
		// message.setText(");

		BodyPart bodyPart = new MimeBodyPart();
		bodyPart.setText("Hello\n\r\n" + "\nPlease see attached automation report. \n\r\n" + "\nThanks,\n\r" + "XYZ");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		bodyPart = new MimeBodyPart();
		String driverPath = System.getProperty("user.dir") + File.separator + "GeneratedReport\\";
		String foldername = null;
		String filename = null;

		try {
			foldername = get_filefoldername(driverPath);
			filename = get_filefoldername(driverPath + "\\" + foldername);
		} catch (Exception e) {
			System.out.println("Issue occured while reading file and folder name");
		}

		FileDataSource source = new FileDataSource(driverPath + "\\" + foldername + "\\" + filename);

		bodyPart.setDataHandler(new DataHandler(source));
		bodyPart.setFileName("Automation Report- " + filename);
		multipart.addBodyPart(bodyPart);
		message.setContent(multipart);

		Transport.send(message);

		GenericMethods.logInfo("Done");
		System.out.println("Sent email successfully !");
	}

	public static String get_filefoldername(String Path) {
	
		File get_folders = new File(Path);
		File[] folders = get_folders.listFiles();
		int i = folders.length - 1;
		String latestfolder = folders[i].toString();
		String[] foldername = latestfolder.split("\\\\", -1);
		int p = foldername.length - 1;
		String actual_foldername = foldername[p].toString();

		return actual_foldername;

	}

	private static InternetAddress[] addEmails(String emails) throws AddressException {
		String[] recipientList = emails.split(",");
		InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
		int counter = 0;
		for (String recipient : recipientList) {
			recipientAddress[counter] = new InternetAddress(recipient.trim());
			counter++;
		}
		return recipientAddress;
	}

	public static void main(String[] args) throws MessagingException {
		sendEmail();
	}

}
