package com.dev.webhook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebhookLiveRepository extends JpaRepository<WebhookLiveModel, Integer>{
	WebhookLiveModel findByphone (String phone);
}
