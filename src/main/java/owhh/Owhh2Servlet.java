package owhh;

import java.io.IOException;




import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;
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
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		req.setCharacterEncoding("UTF-8");
		// https://console.cloud.google.com/permissions/projectpermissions?project=owhhdev  => Permossion link
		// In console go to App Engine > Settings > Application Settings. Add SENDER_EMAIL email address to the list of authorised senders.
		String SENDER_EMAIL ="owhhwebsite@gmail.com";
		String SENDER_NAME ="Send from owhh website";
		String RECEIVER_EMAIL = "giopeto0@yahoo.com";
		String RECEIVER_NAME = "Owhh admin";
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String subject = req.getParameter("subject");
		String message = req.getParameter("message");
		
       
       //String SMTP_AUTH_USER ="owhhdev@appspot.gserviceaccount.com";
                               
        Properties props = new Properties(); 
        Session session = Session.getDefaultInstance(props, null);
        try 
        { 
            Message msg = new MimeMessage(session);            
            msg.setReplyTo(new javax.mail.Address[]
    		{
    		    new javax.mail.internet.InternetAddress(email, name)
    		});
            
            msg.setFrom(new InternetAddress(SENDER_EMAIL, SENDER_NAME)); 
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(RECEIVER_EMAIL, RECEIVER_NAME)); 
            msg.setSubject(subject);            
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
        
        
        
        
        
       /* try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(adminMail, "Example.com Admin"));
            msg.addRecipient(Message.RecipientType.TO,
             new InternetAddress(userMail, "Mr. User"));
            msg.setSubject("Your Example.com account has been activated");
            msg.setText("This is text message clearrr");
            Transport.send(msg);

        } catch (AddressException e) {
        	throw new RuntimeException(e);
        } catch (MessagingException e) {
        	throw new RuntimeException(e);
        }
        */
        
        
        
        
        
        
        
       /* try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("georg3Georgiev@gmail.com",
            		InputName1));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    "giopeto0@yahoo.com", "gggg"));
            msg.setSubject(InputSubject);
            msg.setText(InputTextarea);
            Transport.send(msg);
 
        } catch (Exception e) {
            resp.setContentType("text/plain");
            resp.getWriter().println("Something went wrong. Please try again.");
            throw new RuntimeException(e);
        }*/
		
		
		
		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
	}
}
