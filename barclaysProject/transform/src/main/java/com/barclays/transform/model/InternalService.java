/**
 * 
 */
package com.barclays.transform.model;

/**
 * @author marco.caipe
 *
 */
public class InternalService {

	/**
	 * 
	 */
	public InternalRequestType internalRequest;
	public int serviceType;

	public InternalService() {
		super();
	}

	public InternalService(InternalRequestType internalRequest, int serviceType) {
		super();
		this.internalRequest = internalRequest;
		this.serviceType = serviceType;
	}

	public InternalRequestType getInternalRequest() {
		return internalRequest;
	}

	public void setInternalRequest(InternalRequestType internalRequest) {
		this.internalRequest = internalRequest;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public String toString() {
		return "{ \"internalRequest\":{\"operation\":\"" + internalRequest.getOperation() + "\", \"message\":\""
				+ internalRequest.getMessage() + "\",\"messageType\":\"" + internalRequest.getMassageType()
				+ "\"},\"serviceType\":" + serviceType + "}";
	}

}
