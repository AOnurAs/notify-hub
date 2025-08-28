package com.aoa.channels.impl;

import org.springframework.stereotype.Component;

import com.aoa.channels.INotificationChannel;
import com.aoa.entities.MessageRequest;

@Component
public class SmsChannel implements INotificationChannel {

	@Override
	public MessageRequest sendMessage(MessageRequest messageRequest) {
		// TODO Auto-generated method stub
		System.out.println("TODO: inside sendMessage of SMS Channel with messageRequest:" + messageRequest.toString());
		return null;
	}

}
