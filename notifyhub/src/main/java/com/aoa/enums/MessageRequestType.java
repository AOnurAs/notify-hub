package com.aoa.enums;

import lombok.Getter;

@Getter
public enum MessageRequestType {
	SIMPLE_EMAIL("Request via Email"),
	ATTACHMENT_EMAIL("Request via Email"),
	TELEGRAM("Request via Telegram"),
	SMS("Request via SMS");
	
	private String description;
	
	MessageRequestType(String description) {
		this.description = description;
	}

}
