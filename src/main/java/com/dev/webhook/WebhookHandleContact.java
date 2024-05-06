package com.dev.webhook;

public class WebhookHandleContact {
	private WebhookHandleProfile profile;
	private String wa_id;
	public WebhookHandleProfile getProfile() {
		return profile;
	}
	public void setProfile(WebhookHandleProfile profile) {
		this.profile = profile;
	}
	public String getWa_id() {
		return wa_id;
	}
	public void setWa_id(String wa_id) {
		this.wa_id = wa_id;
	}
	
}
