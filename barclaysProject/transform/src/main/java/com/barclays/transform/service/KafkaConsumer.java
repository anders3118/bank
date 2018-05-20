/**
 * 
 */
package com.barclays.transform.service;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.barclays.transform.model.ExternalService;
import com.barclays.transform.model.InternalService;
import com.google.gson.Gson;

/**
 * @author marco.caipe
 *
 */
@Component
public class KafkaConsumer {
	
	// private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics="${jsa.kafka.topic.in}")
    public void processMessage(String message) {
		System.out.println("received content = " + message);
		Gson g = new Gson();
		InternalService internalService =g.fromJson(message, InternalService.class);
		ExternalService externalService = internalService.getExternalService();
		String body = g.toJson(externalService);
		System.out.println(internalService.getServiceType());
		TransformService transformService = new TransformService();
		JSONObject json = new JSONObject(body);
		String xml = XML.toString(json);
		System.out.println(xml);
		transformService.TransformXSLT(internalService.getServiceType(), "Consulta", xml);
    }
}