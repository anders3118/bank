/** 
 * 
 */
package com.barclays.transform.model;

/**
 * @author marco.caipe
 *
 */
public class Service {

	/**
	 * 
	 */
	public int service;
	public String operation;
	public String operationType;
	public String transformName;

	public Service() {
		super();
	}

	public Service(int service, String operation, String operationType, String transformName) {
		super();
		this.service = service;
		this.operation = operation;
		this.operationType = operationType;
		this.transformName = transformName;
	}

	public int getService() {
		return service;
	}

	public void setService(int service) {
		this.service = service;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getTransformName() {
		return transformName;
	}

	public void setTransformName(String transformName) {
		this.transformName = transformName;
	}

}
