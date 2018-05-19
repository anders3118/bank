package com.barclays.orchestrator.model;

public class ExternalServiceResponse {

	public int serviceId;
	public String status;
	
	public ExternalServiceResponse(int serviceId, String status) {
		super();
		this.serviceId = serviceId;
		this.status = status;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
