package com.aoa.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoa.controller.IRestRecipientController;
import com.aoa.controller.RestBaseController;
import com.aoa.dto.DtoRecipient;
import com.aoa.dto.DtoRecipientIU;
import com.aoa.dto.RootEntity;
import com.aoa.service.IRecipientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/recipient")
public class RestRecipientControllerImpl  extends RestBaseController implements IRestRecipientController {
	
	@Autowired
	private IRecipientService recipientService;

	@Override
	@PostMapping("/save-recipient")
	public RootEntity<DtoRecipient> saveRecipient(@RequestBody @Valid DtoRecipientIU recipientIU) {
		return ok(recipientService.saveRecipient(recipientIU));
	}

	@Override
	@PostMapping("/update-recipient/{id}")
	public RootEntity<DtoRecipient> updateRecipient(@PathVariable(name = "id") Long id, @RequestBody @Valid DtoRecipientIU recipientIU) {
		return ok(recipientService.updateRecipient(id, recipientIU));
	}

	@Override
	@DeleteMapping("/delete-recipient/{id}")
	public RootEntity<Boolean> deleteRecipient(@PathVariable(name = "id") Long id) {
		return ok(recipientService.deleteRecipient(id));
	}

	@Override
	@GetMapping("/get-recipient/{name}")
	public RootEntity<List<DtoRecipient>> getRecipientByName(@PathVariable(name = "name") String name) {
		return ok(recipientService.getRecipientByName(name));

	}

	@Override
	@GetMapping("/get-all")
	public RootEntity<List<DtoRecipient>> getRecipientList() {
		return ok(recipientService.getRecipientList());
	}

}
