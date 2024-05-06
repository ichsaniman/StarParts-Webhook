package com.dev.webhook;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebhookMessageRepository extends JpaRepository<WebhookModel, String>{
	
	Optional<WebhookModel> findById (String id);

}
