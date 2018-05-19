package com.barclays.orchestrator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.orchestrator.model.ExternalService;
import com.barclays.orchestrator.model.ExternalServiceResponse;
import com.barclays.orchestrator.model.InternalService;
import com.barclays.orchestrator.service.KafkaSender;
import com.barclays.orchestrator.service.PayService;

@RestController
@RequestMapping(value = "/barclays/")
public class ExternalServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalServiceController.class);

	@Autowired
	private KafkaSender kafkaSender;

	@RequestMapping(value = {
			"/pagoServicios/{serviceType}" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<ExternalServiceResponse> payPublicService(@PathVariable("serviceType") int serviceType,
			@RequestBody(required = true) ExternalService externalService) {
		LOGGER.info("Recibiendo petición para pago de servicios");
		
		ResponseEntity<ExternalServiceResponse> response = null;
		PayService payService = new PayService();
		InternalService internalService = payService.PayServiceOrch(externalService, serviceType);
		
		kafkaSender.send(internalService);
		response = new ResponseEntity<ExternalServiceResponse>(new ExternalServiceResponse(1234567889, "Pagado"),
				HttpStatus.OK);
		return response;

	}

}
