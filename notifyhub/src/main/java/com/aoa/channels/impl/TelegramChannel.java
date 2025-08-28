package com.aoa.channels.impl;

import org.springframework.stereotype.Component;

import com.aoa.channels.INotificationChannel;
import com.aoa.entities.MessageRequest;

@Component
public class TelegramChannel implements INotificationChannel {

	@Override
	public MessageRequest sendMessage(MessageRequest messageRequest) {
		System.out.println("TODO: inside sendMessage of Telegram Channel with messageRequest:" + messageRequest.toString());
		return null;
	}

}
