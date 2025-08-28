package com.aoa.channels;

import com.aoa.entities.MessageRequest;

public interface INotificationChannel {
	
	public MessageRequest sendMessage(MessageRequest messageRequest);

}
