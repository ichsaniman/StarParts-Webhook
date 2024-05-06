package com.dev.webhook.template;

import java.util.List;

public class WebhookHandleTemplate {
	private String object;
private List<WebhookHandleTemplateEntry> entry;
	
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public List<WebhookHandleTemplateEntry> getEntry() {
		return entry;
	}
	public void setEntry(List<WebhookHandleTemplateEntry> entry) {
		this.entry = entry;
	}
	@Override
	public String toString() {
		return "{object=" + object + ", entry=" + entry + "}";
	}
}
