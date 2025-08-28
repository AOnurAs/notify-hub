package com.aoa.exception;

import lombok.Getter;

@Getter
public enum MessageType {
	NO_RECORD_EXIST("1004", "No record found"),
	USERNAME_NOT_FOUND("1006", "Username not found in the database"),
	INVALID_USERNAME_PASSWORD_COMBINATION("1009", "Username or password is incorrect"),
	EMAIL_SERVER_ERROR("2000", "An error occured while sending email"),
	GENERAL_EXCEPTION("9999", "An error occured");
	
	private String code;
	private String message;
	
	MessageType(String code, String message) {
		this.message = message;
		this.code = code;
	}
}
