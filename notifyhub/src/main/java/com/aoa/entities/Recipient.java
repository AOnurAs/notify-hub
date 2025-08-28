package com.aoa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "recipient")
@AllArgsConstructor
@NoArgsConstructor
public class Recipient extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telegram_id")
	private String telegramId;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
}
