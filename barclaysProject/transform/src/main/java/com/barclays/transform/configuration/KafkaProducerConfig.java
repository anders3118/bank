package com.barclays.transform.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

	@Value("${jsa.kafka.bootstrap-servers}")
	private String bootstrapServer;


}
