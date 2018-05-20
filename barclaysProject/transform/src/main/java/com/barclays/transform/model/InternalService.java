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
	public ExternalService externalService;
	public int serviceType;

	public InternalService() {
		super();
	}

	public InternalService(ExternalService externalService, int serviceType) {
		super();
		this.externalService = externalService;
		this.serviceType = serviceType;
	}

	public ExternalService getExternalService() {
		return externalService;
	}

	public void setExternalService(ExternalService externalService) {
		this.externalService = externalService;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public String toString() {
		return "{ externalService:{serviceId:" + externalService.getServiceId() + "},serviceType:" + serviceType
				+ "}";
	}

}
