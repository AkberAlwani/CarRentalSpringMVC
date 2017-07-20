package cs544.carrental.emailSender;

import java.io.IOException;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class EmailSenderMain {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello Akber");
		Email from = new Email("akberalwani@gamil.com");
	    String subject = "Hello World from the SendGrid Java Library!";
	    Email to = new Email("aali@mum.edu;lau.paul@gmail.com");
	    Content content = new Content("text/plain", "Hello, Email!");
	    Mail mail = new Mail(from, subject, to, content);
//	    mail.setTemplateId("c2fdca09-bc06-416c-bb0b-31b5c6a9feb2");
	    mail.setSubject("Hello CarRental System Subject");

	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.method = Method.POST;
	      request.endpoint = "mail/send";
	      request.body = mail.build();
	      Response response = sg.api(request);
	      System.out.println(response.statusCode);
	      System.out.println(response.body);
	      System.out.println(response.headers);
	    } catch (IOException ex) {
	      throw ex;
	    }
	}

}
