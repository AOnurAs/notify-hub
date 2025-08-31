package com.aoa.channels.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.aoa.channels.INotificationChannel;
import com.aoa.entities.MessageRequest;
import com.aoa.enums.MessageRequestStatus;
import com.aoa.exception.BaseExcepiton;
import com.aoa.exception.ErrorMessage;
import com.aoa.exception.MessageType;
import com.aoa.utils.MailSenderFactory;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class AttachmentEmailChannel implements INotificationChannel{

	@Value("${spring.mail.username}") private String senderUsername;
    @Value("${spring.mail.password}") private String senderPassword;

	@Override
	public MessageRequest sendMessage(MessageRequest messageRequest) {
		
		JavaMailSender mailSender = MailSenderFactory.getDynamicMailSender(senderUsername, senderPassword);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(senderUsername);
            mimeMessageHelper.setTo(messageRequest.getRecipient().getEmail());
            mimeMessageHelper.setText(messageRequest.getMsgBody());
            mimeMessageHelper.setSubject(messageRequest.getSubject());

            // Adding the attachment
            FileSystemResource file = new FileSystemResource(new File(messageRequest.getAttachment()));

            mimeMessageHelper.addAttachment(
                file.getFilename(), file);

            // Sending the mail
            mailSender.send(mimeMessage);
            return messageRequest;
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {
        		messageRequest.setRequestStatus(MessageRequestStatus.ERROR_OCCURED);
    			System.out.println("an error occured while sneding email : " + e.toString());
            throw new BaseExcepiton(	new ErrorMessage(MessageType.EMAIL_SERVER_ERROR, e.toString()));
    					
        }
	}

}
