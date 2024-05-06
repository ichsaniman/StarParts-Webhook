package com.dev.webhook;

import java.util.List;

public class WebhookHandleModel {
	private String object;
	private List<WebhookHandleEntry> entry;
	
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public List<WebhookHandleEntry> getEntry() {
		return entry;
	}
	public void setEntry(List<WebhookHandleEntry> entry) {
		this.entry = entry;
	}
	@Override
	public String toString() {
		return "{object=" + object + ", entry=" + entry + "}";
	}
	
	
	
}
