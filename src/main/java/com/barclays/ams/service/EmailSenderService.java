package com.barclays.ams.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	public JavaMailSender javaMailSender;

	public void sendMail(String toEmail, String subject, String body) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("radhika.singh9110@gmail.com");
			message.setTo(toEmail);
			message.setText(body);
			message.setSubject(subject);
			javaMailSender.send(message);
			System.out.println("Mail Sent successfully");
		} catch (MailException e) {
			e.printStackTrace();
		}
	}

}
