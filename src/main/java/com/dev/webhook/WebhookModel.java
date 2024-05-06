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
@Table(name = "\"SP_MESSAGES\"")
public class WebhookModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "\"MESSAGE_ID\"")
	private String id;
	
	@Column(name = "\"MESSAGE_FROM\"")
	private String from;
	
	@Column(name = "\"MESSAGE_TIMESTAMP\"")
	private BigInteger time;
	
	@Column(name = "\"MESSAGE_TYPE\"")
	private String type;
	
	@Column(name = "\"MESSAGE_CAPTION\"")
	private String caption;
	
	@Column(name = "\"MESSAGE_MEDIA_ID\"")
	private String mediaId;
	
	@Column(name = "\"MESSAGE_FILENAME\"")
	private String fileName;
	
	
	@Column(name = "\"MESSAGE_BODY\"")
	private String messages;
	
	@Column(name = "\"MESSAGE_PATH\"")
	private String path;
	
	@Column(name = "\"MESSAGE_TO\"")
	private String to;

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

	public BigInteger getTime() {
		return time;
	}

	public void setTime(BigInteger time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
}
