package com.flightBookingSystem.emailSender.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderResource {

	

		@Autowired
		private JavaMailSender javaMailSender;

		@RequestMapping(value = "/sendEmail")
		public String sendEmail() {
			sendMail();
			return "Email sent successfully";
		}

		private void sendMail() {

			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo("aryantripathilpu@gmail.com");

			msg.setSubject("Testing from Spring Boot");
			msg.setText("Hello World \n Spring Boot Email");

			javaMailSender.send(msg);
		
	}
}
