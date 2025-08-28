package com.aoa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aoa.channels.INotificationChannel;
import com.aoa.dto.DtoMessageRequest;
import com.aoa.dto.DtoMessageRequestIU;
import com.aoa.entities.MessageRequest;
import com.aoa.enums.MessageRequestType;
import com.aoa.repository.MessageRequestRepository;
import com.aoa.service.BaseNotificationService;
import com.aoa.service.INotificationService;

@Service
public class TelegramNotificationService extends BaseNotificationService implements INotificationService {

	@Autowired
	private MessageRequestRepository messageRequestRepository;
	
	@Autowired
	@Qualifier("telegramChannel")
	private INotificationChannel telegramChannel; 
	
	@Override
	public DtoMessageRequest SendNotification(DtoMessageRequestIU reqeust) {
		MessageRequest messageRequest = createMessageRequest(reqeust, MessageRequestType.TELEGRAM);
		messageRequestRepository.save(messageRequest);
		
		telegramChannel.sendMessage(messageRequest);
		
		DtoMessageRequest dtoMessageRequest = new DtoMessageRequest(messageRequest);
		return dtoMessageRequest;
	}

	@Override
	public List<DtoMessageRequest> getLogs() {
	    return messageRequestRepository.findAll()
	            .stream()
	            .map(DtoMessageRequest::new) // calls your constructor that accepts MessageRequest
	            .collect(Collectors.toList());
	}

}
