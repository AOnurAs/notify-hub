package com.aoa.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError<E> {
	
	private Integer status;
	
	private ErrorLog errorLog;
	
	private E message;
}
