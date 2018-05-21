/**
 * 
 */
package com.barclays.transform.model;

/**
 * @author marco.caipe
 *
 */
public class InternalResponse {

	/**
	 * 
	 */
	public String message;
	public String messageType;

	public InternalResponse() {
		super();
	}

	public InternalResponse(String message, String messageType) {
		super();
		this.message = message;
		this.messageType = messageType;
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
