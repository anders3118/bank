/**
 * 
 */
package com.barclays.orchestrator.model;

/**
 * @author marco.caipe
 *
 */
public class ExternalService {

	/**
	 * 
	 */
	public int serviceId;

	public ExternalService() {
		super();
	}

	public ExternalService(int serviceId) {
		super();
		this.serviceId = serviceId;

	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
}
