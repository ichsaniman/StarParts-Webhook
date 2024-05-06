package com.dev.webhook;

import java.util.List;

public class WebhookHandleEntry {
	private String id;
	private List<WebhookHandleChanges> changes;

	public List<WebhookHandleChanges> getChanges() {
		return changes;
	}

	public void setChanges(List<WebhookHandleChanges> changes) {
		this.changes = changes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
}
