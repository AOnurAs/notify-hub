package com.aoa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoa.dto.DtoRecipient;
import com.aoa.dto.DtoRecipientIU;
import com.aoa.entities.Recipient;
import com.aoa.exception.BaseExcepiton;
import com.aoa.exception.ErrorMessage;
import com.aoa.exception.MessageType;
import com.aoa.repository.RecipientRepository;
import com.aoa.service.IRecipientService;

import jakarta.transaction.Transactional;

@Service
public class RecipientServiceImpl implements IRecipientService {
	
	@Autowired
	private RecipientRepository recipientRepository;

	@Transactional
	@Override
	public DtoRecipient saveRecipient(DtoRecipientIU recipientIU) {
		Recipient recipient= new Recipient();
		BeanUtils.copyProperties(recipientIU, recipient);
		recipient.setCreateTime(new Date());
		recipientRepository.save(recipient);
		
		DtoRecipient dtoRecipient = new DtoRecipient();
		BeanUtils.copyProperties(recipient, dtoRecipient);
		return dtoRecipient;
	}

	@Transactional
	@Override
	public DtoRecipient updateRecipient(Long id, DtoRecipientIU recipientIU) {
		Recipient dbRecipient = recipientRepository.findById(id)
	            .orElseThrow(() -> new BaseExcepiton(
	                    new ErrorMessage(MessageType.NO_RECORD_EXIST, "(updateRecipient funciton) Record of recipient with id " + id + " couldnt be found in the database")));

		dbRecipient.setName(recipientIU.getName());
		dbRecipient.setEmail(recipientIU.getEmail());
		dbRecipient.setPhoneNo(recipientIU.getPhoneNo());
		dbRecipient.setTelegramId(recipientIU.getTelegramId());		
		
		recipientRepository.save(dbRecipient);
		
		DtoRecipient dtoRecipient = new DtoRecipient();
		BeanUtils.copyProperties(dbRecipient, dtoRecipient);
		
		return dtoRecipient;
	}

	@Override
	public Boolean deleteRecipient(Long id) {
		Recipient recipient = recipientRepository.findById(id)
				.orElseThrow(() -> new BaseExcepiton(
						new ErrorMessage(MessageType.NO_RECORD_EXIST, "(deleteRecipient funciton) Record of recipient with id " + id + " couldnt be found in the database")));
		
	    recipientRepository.delete(recipient);
		return true;
	}

	@Override
	public List<DtoRecipient> getRecipientByName(String name) {
	    List<Recipient> recipients = recipientRepository.findByNameContainingIgnoreCase(name);
	    
	    if (recipients.isEmpty()) {
	        throw new BaseExcepiton(
	            new ErrorMessage(MessageType.NO_RECORD_EXIST, "No recipients found with name: " + name)
	        );
	    }

	    return recipients.stream()
	    	    .map(r -> {
	    	        DtoRecipient dto = new DtoRecipient();
	    	        BeanUtils.copyProperties(r, dto);
	    	        return dto;
	    	    })
	    	    .toList();
	    
	}

	@Override
	public List<DtoRecipient> getRecipientList() {
		
		List<Recipient> recipients = recipientRepository.findAll();
		
		if(recipients.isEmpty()) {
			throw new BaseExcepiton(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, "No record found in the database"));
		}
		
		return recipients.stream()
				.map(r -> {
					DtoRecipient dtoRecipient = new DtoRecipient();
					BeanUtils.copyProperties(r, dtoRecipient);
					return dtoRecipient;
				})
				.toList();
	}

}
