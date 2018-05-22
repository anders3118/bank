/**
 * 
 */
package com.barclays.transform.service;

import com.barclays.transform.model.InternalResponseType;
import com.barclays.transform.model.InternalServiceRSType;

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

	public InternalServiceRSType CreateMessageResponse(String messageResponse, String messageType, int serviceType) {
		InternalResponseType internalResponse = new InternalResponseType();
		internalResponse.setMessage(messageResponse);
		internalResponse.setMassageType(messageType);

		InternalServiceRSType internalServiceResponse = new InternalServiceRSType();
		internalServiceResponse.setInternalResponse(internalResponse);
		internalServiceResponse.setServiceType(serviceType);
		return internalServiceResponse;
	}



}
