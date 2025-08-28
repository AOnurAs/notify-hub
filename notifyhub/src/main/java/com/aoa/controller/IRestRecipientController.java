package com.aoa.controller;

import java.util.List;

import com.aoa.dto.DtoRecipient;
import com.aoa.dto.DtoRecipientIU;
import com.aoa.dto.RootEntity;

public interface IRestRecipientController {
	
	public RootEntity<DtoRecipient> saveRecipient(DtoRecipientIU recipientIU);
	
	public RootEntity<DtoRecipient> updateRecipient(Long id, DtoRecipientIU recipientIU);
	
	public RootEntity<Boolean> deleteRecipient(Long id);
	
	public RootEntity<List<DtoRecipient>> getRecipientByName(String name);
	
	public RootEntity<List<DtoRecipient>> getRecipientList();

}
