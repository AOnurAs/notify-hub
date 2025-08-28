package com.aoa.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoa.controller.INotificationController;
import com.aoa.controller.RestBaseController;
import com.aoa.dto.DtoMessageRequest;
import com.aoa.dto.DtoMessageRequestIU;
import com.aoa.dto.RootEntity;
import com.aoa.service.INotificationService;

@RestController
@RequestMapping("/request/telegram")
public class RestTelegramNotificationController extends RestBaseController implements INotificationController {
	
	@Autowired
	@Qualifier("telegramNotificationService")
	private INotificationService telegramNotificationService;

	@Override
	@PostMapping("/send")
	public RootEntity<DtoMessageRequest> sendNotification(@RequestBody DtoMessageRequestIU request) {
		return ok(telegramNotificationService.SendNotification(request));
	}

	@Override
	@GetMapping("/get-logs")
	public RootEntity<List<DtoMessageRequest>> getLogs() {
		return ok(telegramNotificationService.getLogs());
	}

}
