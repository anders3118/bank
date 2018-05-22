/**
 * 
 */
package com.barclays.transform.service;

import com.barclays.transform.model.InternalResponseType;
import com.barclays.transform.model.InternalServiceResponse;

/**
 * @author marco.caipe
 *
 */
public class CreateIMessageResponse {

	/**
	 * 
	 */
	public CreateIMessageResponse() {
		super();
	}

	public InternalServiceResponse CreateMessageResponse(String messageResponse, String messageType, int serviceType) {
		InternalResponseType internalResponse = new InternalResponseType();
		internalResponse.setMessage(messageResponse);
		internalResponse.setMassageType(messageType);

		InternalServiceResponse internalServiceResponse = new InternalServiceResponse();
		internalServiceResponse.setInternalResponse(internalResponse);
		internalServiceResponse.setServiceType(serviceType);
		return internalServiceResponse;
	}



}
