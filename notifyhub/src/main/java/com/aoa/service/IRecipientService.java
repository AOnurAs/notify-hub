package com.aoa.service;

import java.util.List;

import com.aoa.dto.DtoRecipient;
import com.aoa.dto.DtoRecipientIU;

public interface IRecipientService {

	public DtoRecipient saveRecipient(DtoRecipientIU recipientIU);
	
	public DtoRecipient updateRecipient(Long id, DtoRecipientIU recipientIU);
	
	public Boolean deleteRecipient(Long id);
	
	public List<DtoRecipient> getRecipientByName(String name);
	
	public List<DtoRecipient> getRecipientList();


}
