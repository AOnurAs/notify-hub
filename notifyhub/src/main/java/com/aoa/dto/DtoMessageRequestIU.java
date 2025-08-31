package com.aoa.dto;

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
public class DtoMessageRequestIU {
	
	private String msgBody;
	
	private String subject;
	
	private String attachment;
	
	private Long userId;
	
	private Long recipientId;


}
