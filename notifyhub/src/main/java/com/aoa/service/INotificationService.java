package com.aoa.service;

import java.util.List;

import com.aoa.dto.DtoMessageRequest;
import com.aoa.dto.DtoMessageRequestIU;

public interface INotificationService {
	
	public DtoMessageRequest SendNotification(DtoMessageRequestIU reqeust);

	public List<DtoMessageRequest> getLogs();

}
