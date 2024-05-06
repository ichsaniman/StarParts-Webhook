package com.dev.webhook.template;

import java.util.List;

public class WebhookHandleTemplateValue {
	private String messagingProduct;
	private TemplateMetadata metadata;
	private List<TemplateStatuses> statuses;
	
	public String getMessagingProduct() {
		return messagingProduct;
	}
	public void setMessagingProduct(String messagingProduct) {
		this.messagingProduct = messagingProduct;
	}
	public TemplateMetadata getMetadata() {
		return metadata;
	}
	public void setMetadata(TemplateMetadata metadata) {
		this.metadata = metadata;
	}
	public List<TemplateStatuses> getStatuses() {
		return statuses;
	}
	public void setStatuses(List<TemplateStatuses> statuses) {
		this.statuses = statuses;
	}
	
	
}
