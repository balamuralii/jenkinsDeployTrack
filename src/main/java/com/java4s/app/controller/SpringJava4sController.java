/* 
 * Author ::. Sivateja Kandula | www.java4s.com 
 *
 */

package com.java4s.app.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java4s.app.repository.SpringJava4sDAO;
import com.java4s.model.location;

@RestController
public class SpringJava4sController {
	
	@Autowired
	public SpringJava4sDAO dao;
	
		
	@RequestMapping(value = "/sendmail")
	   public String sendEmail() throws AddressException, MessagingException, IOException {
		
		sendmail();
	      return "Email has been sent successfully";
	   }  

	@RequestMapping("/getcustLocation")
	public List<location> customerLocation() {
		
		List<location> customers = dao.isData();		 
		
		return customers;
	}
	
	@PostMapping("/saveLocation")
	public JSONObject saveLocation(@RequestBody location location) {	
		System.out.println("loca details ........"+location.getCreatedTime()+" user id is ==="+location.getUserId());
		
		int row = dao.saveLocation(location);
			JSONObject json = new JSONObject(); 
		if(row>0) {
			json.put("statusCode", "0");
			json.put("message", "success");
		}else{
			json.put("statusCode", "1");
			json.put("message", "Failed");
		}
		return json;
	}
	
	
	
	
	
	@RequestMapping(value = "/retrieveLocById/{id}")
	@ResponseBody
	public location sendLocationbasedOnId(@PathVariable("id") String id) {
		
		location location= dao.findByCustomerId(id);
	    return location;
	}
	
	
	
	
	
	@RequestMapping("/say")
	public String sayHello() {
		
		//List<location> customers = dao.isData();		 
		
		return "Hell booo";
	}
	
	
	
	private void sendmail() throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("balamuralipati@gmail.com", "Pati1205");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("balamuralipati@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("balamuralipati@gmail.com"));
		   msg.setSubject("Your location services OTP");
		   msg.setContent("your OTP is 123456", "text/html");
		   msg.setSentDate(new Date());

//		   MimeBodyPart messageBodyPart = new MimeBodyPart();
//		   messageBodyPart.setContent("Your otp is", "text/html");
//
//		   Multipart multipart = new MimeMultipart();
//		   multipart.addBodyPart(messageBodyPart);
//		   MimeBodyPart attachPart = new MimeBodyPart();

		  // attachPart.attachFile("/home/balamurali/Pictures/Desert-2-768x432.jpg");
		   //multipart.addBodyPart(attachPart);
		   //msg.setContent(multipart);
		   Transport.send(msg);   
		}
}

//URL: http://localhost:8080/springbootds/getcustInfo