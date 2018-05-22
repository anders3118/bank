/**
 * 
 *//*
package com.barclays.transform.service;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.barclays.transform.model.InternalRequest;
import com.barclays.transform.model.InternalService;
import com.google.gson.Gson;

*//**
 * @author marco.caipe
 *
 *//*
@Component
public class KafkaConsumer {

	@Autowired
	KafkaSender kafkaSender;
	
	@KafkaListener(topics = "${jsa.kafka.topic.in}")
	public void processMessage(String message) {
		System.out.println("received content = " + message);
		Gson g = new Gson();
		InternalService internalService;
		internalService = g.fromJson(message, InternalService.class);
		InternalRequest internalRequest = internalService.getInternalRequest();

		//String body = g.toJson(internalRequest.getMessage());
		String xml = null;

		if (body.contains("<")) {
			xml = body;
		} else {
			body = body.substring(1, body.length() - 1);
			body = body.replace("\\", "");
			JSONObject json = new JSONObject(body);
			xml = XML.toString(json);
			xml = "<root>" + xml + "</root>";
		}
		TransformService transformService = new TransformService();
		String transformResult = transformService.TransformXSLT(internalService.getServiceType(),
				internalRequest.getOperation(), internalRequest.getMessageType(), xml);
		transformResult =  transformResult.replace("\"", "\\\"");
		CreateIMessageResponse createIMessageResponse = new CreateIMessageResponse();
//		String messageToSend = createIMessageResponse.CreateMessageResponse(transformResult,
//				internalRequest.getMessageType(), internalService.getServiceType());
//		kafkaSender.send(messageToSend);
	}
}*/