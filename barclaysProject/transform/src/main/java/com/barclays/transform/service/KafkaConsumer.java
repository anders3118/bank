/**
 * 
 */
package com.barclays.transform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.barclays.transform.model.InternalRequestType;
import com.barclays.transform.model.InternalServiceRQType;
import com.barclays.transform.model.InternalServiceRSType;
import com.google.gson.Gson;

/**
 * @author marco.caipe
 *
 */
@Component
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@Autowired
	KafkaSender kafkaSender;
	
	@Value("${path.to.file}")
		private String path;
	
	@KafkaListener(topics = "${jsa.kafka.topic.in}")
	public void processoMessage(String message) {

		LOGGER.info("Recibiendo petición para transformación de servicios");
		
		Gson g = new Gson();
		InternalServiceRQType internalService;
		internalService = g.fromJson(message, InternalServiceRQType.class);

		System.out.println("received content = " + internalService.toString());

		InternalServiceRQType inteService = internalService;
		InternalRequestType internalRequest = inteService.getInternalRequest();
		InternalServiceRSType internalServiceResponse = null;
		CreateIMessageResponse createIMessageResponse = null;
		TransformService transformService = new TransformService();
		String transformResult = transformService.TransformXSLT(internalService.getServiceType(),
				internalRequest.getOperation(), internalRequest.getMassageType(), internalRequest.getMessage(), path);

		createIMessageResponse = new CreateIMessageResponse();
		internalServiceResponse = createIMessageResponse.CreateMessageResponse(transformResult,
				internalRequest.getMassageType(), internalService.getServiceType());

		
		kafkaSender.send(internalServiceResponse.toString());
	}
}	