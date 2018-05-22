/**
 * 
 */
package com.barclays.transform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.transform.model.InternalRequestType;
import com.barclays.transform.model.InternalServiceRQType;
import com.barclays.transform.model.InternalServiceRSType;
import com.barclays.transform.service.CreateIMessageResponse;
import com.barclays.transform.service.TransformService;

/**
 * @author marco.caipe
 *
 */

@RestController
public class TransformController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransformController.class);

	/**
	 * 
	 */
	public TransformController() {
		// TODO Auto-generated constructor stub
	}

	@Value("${path.to.file}")
	private String path;
	
	@RequestMapping(value = {
			"/v1" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<InternalServiceRSType> payPublicService(
			@RequestBody(required = true) InternalServiceRQType internalService) {
		LOGGER.info("Recibiendo petición para transformación de servicios");

		ResponseEntity<InternalServiceRSType> response = null;
		System.out.println("received content = " + internalService.toString());

		InternalServiceRQType inteService = internalService;
		InternalRequestType internalRequest = inteService.getInternalRequest();
		InternalServiceRSType internalServiceResponse = null;
		CreateIMessageResponse createIMessageResponse = null;
		TransformService transformService = new TransformService();
		String transformResult = transformService.TransformXSLT(internalService.getServiceType(),
				internalRequest.getOperation(), internalRequest.getMassageType(), internalRequest.getMessage(), path);

		if (!transformResult.contains("Exception")) {
			createIMessageResponse = new CreateIMessageResponse();
			internalServiceResponse = createIMessageResponse.CreateMessageResponse(transformResult,
					internalRequest.getMassageType(), internalService.getServiceType());
			response = new ResponseEntity<InternalServiceRSType>(internalServiceResponse, HttpStatus.OK);
		} else {
			createIMessageResponse = new CreateIMessageResponse();
			internalServiceResponse = createIMessageResponse.CreateMessageResponse(transformResult,
					internalRequest.getMassageType(), internalService.getServiceType());
			response = new ResponseEntity<InternalServiceRSType>(internalServiceResponse,
					HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}

		return response;

	}

}
