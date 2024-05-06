package com.dev.webhook;

import java.math.BigInteger;

public class WebhookHandleMessages {
	private String from;
	private String id;
	private BigInteger timestamp;
	private String type;
	private WebhookHandleBody text;
	private WebhookHandleImage image;
	private WebhookHandleDocument document;
	private WebhookHandleContext context;
	private WebhookHandleSticker sticker;
	private WebhookHandleAudio audio;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigInteger getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(BigInteger timestamp) {
		this.timestamp = timestamp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public WebhookHandleBody getText() {
		return text;
	}
	public void setText(WebhookHandleBody text) {
		this.text = text;
	}
	public WebhookHandleImage getImage() {
		return image;
	}
	public void setImage(WebhookHandleImage image) {
		this.image = image;
	}
	public WebhookHandleDocument getDocument() {
		return document;
	}
	public void setDocument(WebhookHandleDocument document) {
		this.document = document;
	}
	public WebhookHandleContext getContext() {
		return context;
	}
	public void setContext(WebhookHandleContext context) {
		this.context = context;
	}
	public WebhookHandleSticker getSticker() {
		return sticker;
	}
	public void setSticker(WebhookHandleSticker sticker) {
		this.sticker = sticker;
	}
	public WebhookHandleAudio getAudio() {
		return audio;
	}
	public void setAudio(WebhookHandleAudio audio) {
		this.audio = audio;
	}
	
	
	
	
	
	
	
	
	
}
