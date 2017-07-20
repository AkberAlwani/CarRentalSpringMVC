package cs544.carrental.emailservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cs544.carrental.domain.Customer;
import cs544.carrental.domain.Reservation;
import cs544.carrental.domain.Vehicle;

public class Main {
	public static void main(String[] args) throws MessagingException, ParseException {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");

//		final String username = "akberalwani@gmail.com";
//		final String password = "xxxxx";
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		});
//		try {
//
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("akberalwani@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("akberalwani@gmail.com"));
//			message.setSubject("Test JCG Example");
//			message.setText("Hi," +
//					"This is a Test mail for JCG Example!");
//			Transport.send(message);
//			System.out.println("Mail sent succesfully!");
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}

		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date d1 = df.parse("07-18-2017"); // for example, today's date
		Date d2 = df.parse("07-20-2017"); // use your own dates, of course

		Vehicle vehicle = new Vehicle();
		vehicle.setDailyFine(10);
		vehicle.setMake("Toyota");
		vehicle.setModel("Nissan");

		Customer cust = new Customer();
		cust.setFirstName("Akber ");
		cust.setLastName("Last Name");
		cust.setEmail("akberalwani@gmail.com");
		cust.setId(1);

		Reservation reservation = new Reservation();
		reservation.setReservationId(1);
		reservation.setPickUpDateTime(d1);
		reservation.setReservationDateTime(d2);
		reservation.setMileageIn(13000);
		reservation.setDailyRate(35);
		reservation.setFinePerDay(5);
		reservation.setPricePerDay(35);
		reservation.setCustomer(cust);
		reservation.setVehicle(vehicle);

		String documentName = "AlarmClock.docx";
		EmailService emailService = (EmailService) context.getBean("emailService");
		emailService.sendOrderReceivedMail(cust.getFirstName(), cust.getEmail(), reservation, documentName,
				new Locale("en"));

		System.out.println("You Have BOOKED with us Car !!");

	}

}