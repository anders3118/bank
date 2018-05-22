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

	public InternalResponseType internalResponse;
	public int serviceType;

	public InternalServiceResponse() {
		super();
	}

	public InternalServiceResponse(InternalResponseType internalResponse, int serviceType) {
		super();
		this.internalResponse = internalResponse;
		this.serviceType = serviceType;
	}

	public InternalResponseType getInternalResponse() {
		return internalResponse;
	}

	public void setInternalResponse(InternalResponseType internalResponse) {
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
				+ internalResponse.getMassageType() + "\"},\"serviceType\":" + serviceType + "}";
	}

}
