package com.aoa.channels.impl;

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
import com.aoa.utils.MailSenderFactory;

@Component
public class SimpleEmailChannel implements INotificationChannel {

	@Value("${spring.mail.username}") private String senderUsername;
    @Value("${spring.mail.password}") private String senderPassword;
    
	@Override
	public MessageRequest sendMessage(MessageRequest messageRequest) {
		
		try {
			JavaMailSender mailSender =
			        MailSenderFactory.getDynamicMailSender(senderUsername, senderPassword);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(senderUsername);
			mailMessage.setTo(messageRequest.getRecipient().getEmail());
			mailMessage.setSubject(messageRequest.getSubject());
			mailMessage.setText(messageRequest.getMsgBody());

			mailSender.send(mailMessage);
	        
	        messageRequest.setRequestStatus(MessageRequestStatus.SENT);
			
	        return messageRequest;
		} catch (Exception e) {
			messageRequest.setRequestStatus(MessageRequestStatus.ERROR_OCCURED);
			System.out.println("an error occured while sneding email : " + e.toString());
            throw new BaseExcepiton(	new ErrorMessage(MessageType.EMAIL_SERVER_ERROR, e.toString()));
					
		}
		
	}

}
