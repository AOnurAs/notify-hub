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
@Table(name = "mail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mail extends BaseEntity{
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;

}
