package com.dev.webhook.template;

public class Pricing {
	private boolean billable;
	private String pricingModel;
	private String category;
	
	public boolean isBillable() {
		return billable;
	}
	public void setBillable(boolean billable) {
		this.billable = billable;
	}
	public String getPricingModel() {
		return pricingModel;
	}
	public void setPricingModel(String pricingModel) {
		this.pricingModel = pricingModel;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
