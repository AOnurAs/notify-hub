package com.aoa.channels.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.aoa.channels.INotificationChannel;
import com.aoa.entities.MessageRequest;
import com.aoa.enums.MessageRequestStatus;
import com.aoa.exception.BaseExcepiton;
import com.aoa.exception.ErrorMessage;
import com.aoa.exception.MessageType;

@Component
public class EmailChannel implements INotificationChannel {

    @Autowired private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;
    
	@Override
	public MessageRequest sendMessage(MessageRequest messageRequest) {
		
		try {
	        SimpleMailMessage mailMessage = new SimpleMailMessage();
			
	        mailMessage.setFrom(sender); //TODO get infos from user*
	        mailMessage.setTo(messageRequest.getRecipient().getEmail()); //TODO if recipient dosent have an email
	        mailMessage.setText(messageRequest.getMessage());
	        mailMessage.setSubject(messageRequest.getUser().getName() + " to " + messageRequest.getRecipient().getName());

	        javaMailSender.send(mailMessage);
	        
	        messageRequest.setRequestStatus(MessageRequestStatus.SENT);
			
	        return messageRequest;
		} catch (Exception e) {
			System.out.println("an error occured while sneding email : " + e.toString());
            throw new BaseExcepiton(	new ErrorMessage(MessageType.EMAIL_SERVER_ERROR, e.toString()));
					
		}
		//messageRequest.setRequestStatus(MessageRequestStatus.ERROR_OCCURED);
		//return messageRequest;
	}
	

}
