/**
 * 
 */
package com.barclays.orchestrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.barclays.orchestrator.model.InternalService;

/**
 * @author marco.caipe
 *
 */
@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, InternalService> kafkaTemplate;
	//private KafkaTemplate<String, String> kafkaTemplate;
	
	//String kafkaTopic = "barclays_routing_In_Topic";
	String kafkaTopic = "java_in_use_topic";
	public void send(InternalService data) {
	    
	    kafkaTemplate.send(kafkaTopic, data);
	}

}
