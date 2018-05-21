/**
 * 
 */
package com.barclays.transform.model;

/**
 * @author marco.caipe
 *
 */
public class InternalServiceResponse {

	/**
	 * 
	 */

	public InternalResponse internalResponse;
	public int serviceType;

	public InternalServiceResponse() {
		super();
	}

	public InternalServiceResponse(InternalResponse internalResponse, int serviceType) {
		super();
		this.internalResponse = internalResponse;
		this.serviceType = serviceType;
	}

	public InternalResponse getInternalResponse() {
		return internalResponse;
	}

	public void setInternalResponse(InternalResponse internalResponse) {
		this.internalResponse = internalResponse;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}
	
	@Override
	public String toString() {
		return "{\"internalResponse\":{\"message\":" + internalResponse.getMessage() + ",messageType\":\""
				+ internalResponse.getMessageType() + "\"},\"serviceType\":" + serviceType + "}";
	}

}
