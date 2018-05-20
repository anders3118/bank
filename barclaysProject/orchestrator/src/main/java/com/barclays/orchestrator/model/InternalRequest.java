/**
 * 
 */
package com.barclays.orchestrator.model;

/**
 * @author marco.caipe
 *
 */
public class InternalRequest {

	/**
	 * 
	 */
	public String operation;
	public String message;
	public String messageType;

	public InternalRequest() {
		super();
	}

	public InternalRequest(String operation, String message, String messageType) {
		super();
		this.operation = operation;
		this.message = message;
		this.messageType = messageType;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

}
