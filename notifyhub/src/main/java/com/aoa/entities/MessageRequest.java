package com.aoa.entities;

import com.aoa.enums.MessageRequestStatus;
import com.aoa.enums.MessageRequestType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "message_request")
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest extends BaseEntity{

	@Column(name = "request_status")
	@Enumerated(EnumType.STRING)
	private MessageRequestStatus requestStatus;

	@Column(name = "request_type")
	@Enumerated(EnumType.STRING)
	private MessageRequestType requestType;
	
	@Column(name = "message")
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "recipient_id")
	private Recipient recipient;

}
