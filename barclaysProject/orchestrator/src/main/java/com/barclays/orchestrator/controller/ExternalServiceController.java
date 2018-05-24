package com.barclays.orchestrator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.barclays.orchestrator.clientservice.RESTClient;
import com.barclays.orchestrator.message.external.PaymentResponseType;
import com.barclays.orchestrator.message.external.PaymentType;
import com.barclays.orchestrator.message.internal.InternalRequestType;
import com.barclays.orchestrator.message.internal.InternalServiceRQType;
import com.barclays.orchestrator.message.internal.InternalServiceRSType;
import com.barclays.orchestrator.message.internal.ProviderType;
import com.barclays.orchestrator.message.internal.RestType;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = { "/paymentService" })
public class ExternalServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalServiceController.class);

	@Autowired
	private RESTClient restClient;

	@Value("${enpoint.routing}")
	private String endpointRouting;

	@Value("${enpoint.dispatcher}")
	private String endpointDispatcher;

	@RequestMapping(value = { "/query/{idFactura}" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<PaymentType> queryService(@PathVariable(required = true) Integer idFactura) {
		LOGGER.info("Recibiendo petición para pago de servicios " + idFactura);
		ResponseEntity<PaymentType> response = null;
		try {
			Integer agreement = Integer.parseInt(idFactura.toString().substring(0, 3));

			ProviderType routing = new ProviderType();
			routing.setRest(new RestType());

			routing.getRest().setEndPoint(String.format("%s%s%s%s", endpointRouting, "/", agreement, "/consulta"));
			routing.getRest().setMethod("GET");

			// Llamar al routing
			LOGGER.info(String.format("Llamando routing %s ", routing.getRest().getEndPoint()));
			ProviderType responseRouting = restClient.callService(routing, null, ProviderType.class);

			// Llamar al dispatcher
			ProviderType dispatcher = new ProviderType();
			dispatcher.setRest(new RestType());
			dispatcher.getRest().setEndPoint(endpointDispatcher);
			dispatcher.getRest().setMethod("POST");

			InternalServiceRQType internalServiceRQ = new InternalServiceRQType();
			internalServiceRQ.setInternalRequest(new InternalRequestType());
			internalServiceRQ.getInternalRequest().setMassageType("Request");
			internalServiceRQ.getInternalRequest().setOperation("Consulta");
			internalServiceRQ.getInternalRequest().setProvider(responseRouting);
			internalServiceRQ.setServiceType(agreement);

			if (responseRouting.getRest() != null && responseRouting.getRest().getMethod().equalsIgnoreCase("GET")) {
				internalServiceRQ.getInternalRequest().setMessage(idFactura.toString());
			} else {
				internalServiceRQ.getInternalRequest().setMessage(String.format("{\"serviceId\" : %d}", idFactura));
			}

			LOGGER.info(String.format("Llamando dispatcher %s ", dispatcher.getRest().getEndPoint()));

			InternalServiceRSType internalServiceRS = restClient.callService(dispatcher, internalServiceRQ,
					InternalServiceRSType.class);

			LOGGER.info("respuesta del distpacher -> " + internalServiceRS.getInternalResponse().getMessage());

			PaymentType payment = new ObjectMapper().readValue(internalServiceRS.getInternalResponse().getMessage(),
					PaymentType.class);

			payment.setService(responseRouting.getName());

			response = new ResponseEntity<>(payment, HttpStatus.OK);
		} catch (HttpClientErrorException e) {
			LOGGER.info("ERROR - ", e);
			response = new ResponseEntity<>(e.getStatusCode());
		} catch (Exception e) {
			LOGGER.info("ERROR - ", e);
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@RequestMapping(value = {
			"/payment" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<PaymentResponseType> paymentService(@RequestBody(required = true) PaymentType payment) {
		ResponseEntity<PaymentResponseType> response = null;
		try {
			Integer agreement = Integer.parseInt(payment.getServiceId().toString().substring(0, 3));

			ProviderType routing = new ProviderType();
			routing.setRest(new RestType());

			routing.getRest().setEndPoint(String.format("%s%s%s%s", endpointRouting, "/", agreement, "/pago"));
			routing.getRest().setMethod("GET");

			// Llamar al routing
			LOGGER.info(String.format("Llamando routing %s ", routing.getRest().getEndPoint()));
			ProviderType responseRouting = restClient.callService(routing, null, ProviderType.class);

			// Llamar al dispatcher
			ProviderType dispatcher = new ProviderType();
			dispatcher.setRest(new RestType());
			dispatcher.getRest().setEndPoint(endpointDispatcher);
			dispatcher.getRest().setMethod("POST");

			InternalServiceRQType internalServiceRQ = new InternalServiceRQType();
			internalServiceRQ.setInternalRequest(new InternalRequestType());
			internalServiceRQ.getInternalRequest().setMassageType("Request");
			internalServiceRQ.getInternalRequest().setOperation("Pago");
			internalServiceRQ.getInternalRequest().setProvider(responseRouting);
			internalServiceRQ.setServiceType(agreement);

			String message = new ObjectMapper().writeValueAsString(payment);
			if (responseRouting.getRest() != null && responseRouting.getRest().getMethod().equalsIgnoreCase("GET")) {

				internalServiceRQ.getInternalRequest().setMessage(message);
			} else {
				internalServiceRQ.getInternalRequest().setMessage(message);
			}

			LOGGER.info(String.format("Llamando dispatcher %s ", dispatcher.getRest().getEndPoint()));

			if (null != internalServiceRQ.getInternalRequest().getProvider().getRest()) {
				String endPoint = internalServiceRQ.getInternalRequest().getProvider().getRest().getEndPoint();
				internalServiceRQ.getInternalRequest().getProvider().getRest()
						.setEndPoint(endPoint + "/" + payment.getServiceId());
			}
			InternalServiceRSType internalServiceRS = restClient.callService(dispatcher, internalServiceRQ,
					InternalServiceRSType.class);

			LOGGER.info("respuesta del distpacher -> " + internalServiceRS.getInternalResponse().getMessage());

			PaymentResponseType paymentResponse = new ObjectMapper()
					.readValue(internalServiceRS.getInternalResponse().getMessage(), PaymentResponseType.class);

			response = new ResponseEntity<>(paymentResponse, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("ERROR - ", e);
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
