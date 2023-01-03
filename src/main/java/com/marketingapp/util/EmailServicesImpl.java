package com.marketingapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServicesImpl implements EmailServices {
    @Autowired
    private JavaMailSender mailsender;
    
	@Override
	public void sendEmail(String to, String subject, String msg) {
		 SimpleMailMessage mailMessage   = new SimpleMailMessage();
		 mailMessage.setTo(to);
		 mailMessage.setSubject(subject);
		 mailMessage.setText(msg);
		 mailsender.send(mailMessage);

		
	}

}
