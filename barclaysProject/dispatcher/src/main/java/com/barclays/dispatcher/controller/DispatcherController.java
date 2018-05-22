package com.barclays.dispatcher.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.dispatcher.config.ClientServiceComponent;
import com.barclays.dispatcher.message.InternalRequestType;
import com.barclays.dispatcher.message.InternalServiceRQType;
import com.barclays.dispatcher.message.InternalServiceRSType;
import com.barclays.dispatcher.message.ProviderType;
import com.barclays.dispatcher.message.RestType;

@RestController
public class DispatcherController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherController.class);

	@Autowired
	private ClientServiceComponent serviceClient;

	@Value("${enpoint.trans}")
	private String endpointDispatcher;

	@RequestMapping(value = "/v1", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<InternalServiceRSType> dispatch(
			@RequestBody(required = true) InternalServiceRQType internalServiceRQ) {

		LOGGER.info("Recibiendo peticion");
		ResponseEntity<InternalServiceRSType> response = null;

		try {
			ProviderType provider = internalServiceRQ.getInternalRequest().getProvider();

			ProviderType providerTrans = new ProviderType();
			providerTrans.setRest(new RestType());
			providerTrans.getRest().setEndPoint(endpointDispatcher);
			providerTrans.getRest().setMethod("POST");

			LOGGER.info("Llamando transformer");

			/* Call transform for request */
			InternalServiceRSType internalRS = serviceClient.getRestClient().callService(providerTrans,
					internalServiceRQ, InternalServiceRSType.class);

			LOGGER.info(String.format("Recibiendo respuesta de trans -> %s",
					internalRS.getInternalResponse().getMessage()));

			/* Call provider */
			LOGGER.info("Llamando proveedor");

			String providerRS;
			if (null != provider.getRest()) {
				providerRS = serviceClient.getRestClient().callService(provider,
						internalRS.getInternalResponse().getMessage(), String.class);
			} else {
				providerRS = serviceClient.getSoapClient().callService(provider,
						internalRS.getInternalResponse().getMessage());
			}

			/* Call transform for response */
			InternalServiceRQType internalServiceResposeProvider = new InternalServiceRQType();
			internalServiceResposeProvider.setInternalRequest(new InternalRequestType());			
			internalServiceResposeProvider.getInternalRequest().setMassageType("response");
			internalServiceResposeProvider.getInternalRequest().setMessage(providerRS);
			internalServiceResposeProvider.getInternalRequest().setOperation("consulta");
			internalServiceResposeProvider.getInternalRequest().setProvider(null);
			internalServiceResposeProvider.setServiceType("consulta");
			LOGGER.info(String.format("Transformando respuesta del proveedor %s", providerRS));
			
			internalRS = serviceClient.getRestClient().callService(providerTrans, internalServiceResposeProvider,
					InternalServiceRSType.class);

			response = new ResponseEntity<>(internalRS, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			LOGGER.error("ERROR - DispatcherController", e);
		}

		return response;
	}
}
