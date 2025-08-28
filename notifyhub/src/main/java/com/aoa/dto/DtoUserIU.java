package com.aoa.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DtoUserIU {

	@NotNull
	private String name;
	
	@NotNull
	private String username;

	@NotNull
	private String password;
	
	@NotNull
	private DtoMail mail;
}
