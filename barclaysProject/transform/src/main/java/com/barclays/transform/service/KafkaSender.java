/*package com.barclays.transform.service;

*//**
 * 
 *//*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

*//**
 * @author marco.caipe
 *
 *//*
@Service
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${jsa.kafka.topic.out}")
	private String kafkaTopic;

	public void send(String data) {

		kafkaTemplate.send(kafkaTopic, data);
	}

}
*/