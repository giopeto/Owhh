package owhh;

import java.io.IOException;

import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@SuppressWarnings("serial")
public class Owhh2Servlet extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException{
		System.out.println("wtf");
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, wine");
	}


	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		req.setCharacterEncoding("UTF-8");
		// https://console.cloud.google.com/permissions/projectpermissions?project=owhhdev  => Permossion link
		// In console go to App Engine > Settings > Application Settings. Add SENDER_EMAIL email address to the list of authorised senders.
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String subject = req.getParameter("subject");
		String message = req.getParameter("message");

		String encodedUserName = MimeUtility.encodeText(name, "utf-8", "B");

		message += "\n From: " + name + "\n" + "Mail: " + email;

		String SENDER_EMAIL = "owhhwebsite@gmail.com";
		String SENDER_NAME = "Send from owhh website from: " + encodedUserName;
		String RECEIVER_EMAIL = "oldwinehouse@abv.bg";
		String RECEIVER_NAME = "Owhh admin";

		//String SMTP_AUTH_USER ="owhhdev@appspot.gserviceaccount.com";

		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		try {
			Message msg = new MimeMessage(session);
			msg.setHeader("Content-Type", "text/plain; charset=UTF-8");
			msg.setReplyTo(new javax.mail.Address[]
					{
							new javax.mail.internet.InternetAddress(email, name)
					});

			msg.setFrom(new InternetAddress(SENDER_EMAIL, SENDER_NAME));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(RECEIVER_EMAIL, RECEIVER_NAME));
			msg.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));
			// msg.setContent("This is text message clearrr", "text/html");
			msg.setText(message);
			Transport.send(msg);
			//return "";


		} catch (AddressException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}
