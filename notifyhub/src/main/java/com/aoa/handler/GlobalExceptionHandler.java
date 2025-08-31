package com.aoa.handler;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.aoa.exception.BaseExcepiton;
import com.aoa.repository.ErrorLogRepository;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	private ErrorLogRepository errorLogRepository;
	
	@ExceptionHandler(value = {BaseExcepiton.class})
	public ResponseEntity<ApiError> handleBaseException(BaseExcepiton exception, WebRequest webRequest) {
		ErrorLog errorLog = createErrorLog(exception, webRequest);
		errorLogRepository.save(errorLog);
		
		ApiError apiError = createApiError(errorLog, exception.getMessage());
		
		return ResponseEntity.badRequest().body(apiError);
	}
	
	private String getHostname() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.out.println("Error occured getting local host name");
			e.printStackTrace();
		}
		return null;
	}
	
	public ErrorLog createErrorLog(BaseExcepiton exception, WebRequest webRequest) {
		ErrorLog errorLog = new ErrorLog();
		
		errorLog.setCreateTime(new Date());
		errorLog.setType(exception.getErrorMessage().getMessageType());
		errorLog.setMessage(exception.getErrorMessage().getOfStatic());
		errorLog.setHostName(getHostname());
		errorLog.setPath(webRequest.getDescription(false));
		
		return errorLog;
	}
	
	public <E> ApiError<E> createApiError(ErrorLog errorLog, E message){
		ApiError<E> apiError = new ApiError<>();
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		apiError.setErrorLog(errorLog);
		apiError.setMessage(message);
		
		return apiError;
	}

}
