package com.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

@SpringBootApplication
public class DevelopmentWhatsappWebhookApplication {
	@Autowired
	DataSourceProperties dataSourceProperties;
	public static void main(String[] args) {
		SpringApplication.run(DevelopmentWhatsappWebhookApplication.class, args);
		
	}

}
