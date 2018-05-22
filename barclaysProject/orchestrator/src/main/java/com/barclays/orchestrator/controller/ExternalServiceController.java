package com.barclays.orchestrator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.orchestrator.message.external.PaymentResponseType;
import com.barclays.orchestrator.message.external.PaymentType;

@RestController
@RequestMapping(value = { "/paymentService" })
public class ExternalServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalServiceController.class);

	@RequestMapping(value = { "/query/{idFactura}" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<PaymentType> queryService(@PathVariable(required = true) Integer idFactura) {
		
		LOGGER.info("Recibiendo petición para pago de servicios");
		ResponseEntity<PaymentType> response = null;

		return response;
	}

	@RequestMapping(value = { "/payment" }, method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<PaymentResponseType> paymentService(@RequestBody(required = true) PaymentType payment) {

		LOGGER.info("Recibiendo petición para pago de servicios");
		ResponseEntity<PaymentResponseType> response = null;

		return response;
	}

}
