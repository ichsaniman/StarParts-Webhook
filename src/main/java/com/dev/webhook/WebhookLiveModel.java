package com.dev.webhook;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"SP_LIVE_CHAT\"")
@SequenceGenerator(name = "live_id_seq", sequenceName = "live_id_seq", allocationSize = 1)
public class WebhookLiveModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "live_id_seq")
	@Column(name = "\"LIVE_ID\"")
	private int id;
	
	@Column(name = "\"LIVE_PHONE\"")
	private String phone;
	
	@Column(name = "\"LIVE_TIMESTAMP\"")
	private BigInteger timestamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigInteger getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(BigInteger timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
