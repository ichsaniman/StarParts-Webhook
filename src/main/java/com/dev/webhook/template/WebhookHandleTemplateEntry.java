package com.dev.webhook.template;

import java.util.List;

public class WebhookHandleTemplateEntry {
	private String id;
	private List<WebhookHandleTemplateChanges> changes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<WebhookHandleTemplateChanges> getChanges() {
		return changes;
	}
	public void setChanges(List<WebhookHandleTemplateChanges> changes) {
		this.changes = changes;
	}
	
	
}
