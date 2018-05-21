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
	public InternalRequest internalRequest;
	public int serviceType;

	public InternalService() {
		super();
	}

	public InternalService(InternalRequest internalRequest, int serviceType) {
		super();
		this.internalRequest = internalRequest;
		this.serviceType = serviceType;
	}

	public InternalRequest getInternalRequest() {
		return internalRequest;
	}

	public void setInternalRequest(InternalRequest internalRequest) {
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
				+ internalRequest.getMessage() + "\",\"messageType\":\"" + internalRequest.getMessageType()
				+ "\"},\"serviceType\":" + serviceType + "}";
	}

}
