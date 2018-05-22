/**
 * 
 */
package com.barclays.transform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.transform.model.InternalRequestType;
import com.barclays.transform.model.InternalService;
import com.barclays.transform.model.InternalServiceResponse;
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

	@RequestMapping(value = {
			"/v1" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<InternalServiceResponse> payPublicService(
			@RequestBody(required = true) InternalService internalService) {
		LOGGER.info("Recibiendo petición para transformación de servicios");

		ResponseEntity<InternalServiceResponse> response = null;
		System.out.println("received content = " + internalService.toString());

		InternalService inteService = internalService;
		InternalRequestType internalRequest = inteService.getInternalRequest();
		InternalServiceResponse internalServiceResponse = null;
		CreateIMessageResponse createIMessageResponse = null;
		TransformService transformService = new TransformService();
		String transformResult = transformService.TransformXSLT(internalService.getServiceType(),
				internalRequest.getOperation(), internalRequest.getMassageType(), internalRequest.getMessage());

		if (!transformResult.contains("Exception")) {
			createIMessageResponse = new CreateIMessageResponse();
			internalServiceResponse = createIMessageResponse.CreateMessageResponse(transformResult,
					internalRequest.getMassageType(), internalService.getServiceType());
			response = new ResponseEntity<InternalServiceResponse>(internalServiceResponse, HttpStatus.OK);
		} else {
			createIMessageResponse = new CreateIMessageResponse();
			internalServiceResponse = createIMessageResponse.CreateMessageResponse(transformResult,
					internalRequest.getMassageType(), internalService.getServiceType());
			response = new ResponseEntity<InternalServiceResponse>(internalServiceResponse,
					HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}

		return response;

	}

}
