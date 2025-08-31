package com.aoa.exception;

public class BaseExcepiton extends RuntimeException{
	
    private final ErrorMessage errorMessage;

	public BaseExcepiton(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
		super(errorMessage.prepareErrorMessage());
	}
	
    public ErrorMessage getErrorMessage() {
        return this.errorMessage;
    }

}
