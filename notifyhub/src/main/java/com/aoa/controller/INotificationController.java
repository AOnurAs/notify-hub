package com.aoa.controller;

import java.util.List;

import com.aoa.dto.DtoMessageRequest;
import com.aoa.dto.DtoMessageRequestIU;
import com.aoa.dto.RootEntity;

public interface INotificationController {
	
	public RootEntity<DtoMessageRequest> sendNotification(DtoMessageRequestIU request);
	
	public RootEntity<List<DtoMessageRequest>> getLogs();

}
