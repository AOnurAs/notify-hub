package com.aoa.dto;

import org.springframework.beans.BeanUtils;

import com.aoa.entities.MessageRequest;
import com.aoa.enums.MessageRequestStatus;
import com.aoa.enums.MessageRequestType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DtoMessageRequest extends DtoBase{

	private MessageRequestStatus requestStatus;

	private MessageRequestType requestType;
	
	private String msgBody;
	
	private String subject;
	
	private String attachment;
	
	private DtoUser dtoUser;
	
	private DtoRecipient dtoRecipient;
	
	public DtoMessageRequest(MessageRequest messageRequest) {
	    this.dtoUser = new DtoUser();
	    this.dtoRecipient = new DtoRecipient();

	    BeanUtils.copyProperties(messageRequest.getUser(), this.dtoUser);
	    BeanUtils.copyProperties(messageRequest.getRecipient(), this.dtoRecipient);
	    BeanUtils.copyProperties(messageRequest, this);
	}


}
