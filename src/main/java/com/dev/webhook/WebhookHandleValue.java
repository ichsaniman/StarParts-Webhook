package com.dev.webhook;

import java.util.List;

public class WebhookHandleValue {
	private String messaging_product;
	private WebhookHandleMetadata metadata;
	private List<WebhookHandleContact> contacts;
	List<WebhookHandleMessages> messages;

	public List<WebhookHandleMessages> getMessages() {
		return messages;
	}

	public void setMessages(List<WebhookHandleMessages> messages) {
		this.messages = messages;
	}

	public String getMessaging_product() {
		return messaging_product;
	}

	public void setMessaging_product(String messaging_product) {
		this.messaging_product = messaging_product;
	}

	public WebhookHandleMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(WebhookHandleMetadata metadata) {
		this.metadata = metadata;
	}

	public List<WebhookHandleContact> getContacts() {
		return contacts;
	}

	public void setContacts(List<WebhookHandleContact> contacts) {
		this.contacts = contacts;
	}

	
	
	
	
	
	
}
