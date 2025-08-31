package com.aoa.handler;

import com.aoa.entities.BaseEntity;
import com.aoa.exception.MessageType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "error_log")
@AllArgsConstructor
@NoArgsConstructor
public class ErrorLog extends BaseEntity{
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private MessageType type;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "host_name")
	private String hostName;
	
	@Column(name = "path")
	private String path;
		
}
