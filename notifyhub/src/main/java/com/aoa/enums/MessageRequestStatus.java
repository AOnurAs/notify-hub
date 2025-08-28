package com.aoa.enums;

import lombok.Getter;

@Getter
public enum MessageRequestStatus {
	SENT("Request succesfully sent"),
	PENDING("Request is send and waiting for response"),
	ERROR_OCCURED("An error occured while sending the request");
	
	private String description;
	
	MessageRequestStatus(String description) {
		this.description = description;
	}
}
