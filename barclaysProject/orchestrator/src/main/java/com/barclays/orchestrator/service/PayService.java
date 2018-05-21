package com.barclays.orchestrator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.barclays.orchestrator.model.ExternalService;
import com.barclays.orchestrator.model.InternalRequest;
import com.barclays.orchestrator.model.InternalService;

//@RestController
public class PayService {

	public PayService() {
		super();
	}
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PayService.class);
	

	public InternalService PayServiceOrch(ExternalService externalService, int serviceType) {
		LOGGER.info("Construyendo Pago de Servicios");
		InternalRequest internalRequest = new InternalRequest();
		internalRequest.setOperation("Consulta");
		internalRequest.setMessageType("Request");
		internalRequest.setMessage("{\\\"serviceId\\\":" + externalService.serviceId + "}");
		
		InternalService internalService = new InternalService(internalRequest, serviceType);
		LOGGER.info("Enviando a KafkaServer");
		//kafkaSender.send("123");
		return internalService;
	}

}
