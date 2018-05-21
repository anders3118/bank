/**
 * 
 */
package com.barclays.transform.service;

import com.barclays.transform.model.InternalResponse;
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

	public String CreateMessageResponse(String messageResponse, String messageType, int serviceType) {
		InternalResponse internalResponse = new InternalResponse();
		internalResponse.setMessage(messageResponse);
		internalResponse.setMessageType(messageType);

		InternalServiceResponse internalServiceResponse = new InternalServiceResponse();
		internalServiceResponse.setInternalResponse(internalResponse);
		internalServiceResponse.setServiceType(serviceType);
		String messageToSend = internalServiceResponse.toString();
		System.out.println(messageToSend);
		return messageToSend;
	}



}
