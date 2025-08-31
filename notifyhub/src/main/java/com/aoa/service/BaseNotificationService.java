package com.aoa.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.aoa.dto.DtoMessageRequestIU;
import com.aoa.entities.MessageRequest;
import com.aoa.entities.Recipient;
import com.aoa.entities.User;
import com.aoa.enums.MessageRequestStatus;
import com.aoa.enums.MessageRequestType;
import com.aoa.exception.BaseExcepiton;
import com.aoa.exception.ErrorMessage;
import com.aoa.exception.MessageType;
import com.aoa.repository.RecipientRepository;
import com.aoa.repository.UserRepository;

public class BaseNotificationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RecipientRepository recipientRepository;

	public MessageRequest createMessageRequest(DtoMessageRequestIU request, MessageRequestType messageType) {
		MessageRequest messageRequest = new MessageRequest();
		
		Long userId = request.getUserId();
		User user = userRepository.findById(userId)
	            .orElseThrow(() -> new BaseExcepiton(
	                    new ErrorMessage(MessageType.NO_RECORD_EXIST, "(createMessageRequest funciton - BaseNotificationService) Record of user with id " + userId + " couldnt be found in the database")));

		Long recipientId = request.getRecipientId();
		Recipient recipient = recipientRepository.findById(recipientId)
	            .orElseThrow(() -> new BaseExcepiton(
	                    new ErrorMessage(MessageType.NO_RECORD_EXIST, "(createMessageRequest funciton - BaseNotificationService) Record of recipient with id " + recipientId + " couldnt be found in the database")));
		
		messageRequest.setCreateTime(new Date());
		messageRequest.setMsgBody(request.getMsgBody());
		messageRequest.setSubject(request.getSubject());
		messageRequest.setAttachment(request.getAttachment());
		messageRequest.setRecipient(recipient);
		messageRequest.setUser(user);
		messageRequest.setRequestStatus(MessageRequestStatus.PENDING);
		messageRequest.setRequestType(messageType);
		
		return messageRequest;
	}

}
