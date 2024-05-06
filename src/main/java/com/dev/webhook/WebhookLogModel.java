package com.dev.webhook;

import java.io.Serializable;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"SP_MESSAGE_LOG\"")
public class WebhookLogModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "\"MESSAGE_LOG_ID\"")
	private String id;
	
	@Column(name = "\"MESSAGE_LOG_FROM\"")
	private String from;
	
	@Column(name = "\"MESSAGE_LOG_TO\"")
	private String to;
	
	@Column(name = "\"MESSAGE_LOG_STATUS\"")
	private String status;
	
	@Column(name = "\"MESSAGE_LOG_TIMESTAMP\"")
	private BigInteger time;
	
	@Column(name = "\"MESSAGE_LOG_MESSAGES\"")
	private String messages;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigInteger getTime() {
		return time;
	}

	public void setTime(BigInteger time) {
		this.time = time;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}
	
	
	
	
	

}
