package com.aoa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DtoRecipient extends DtoBase{

	private String name;
	
	private String email;
	
	private String telegramId;
	
	private String phoneNo;
}
