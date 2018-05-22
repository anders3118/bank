package com.barclays.orchestrator.exception;

public class OrchestratorException extends RuntimeException {

	private static final long serialVersionUID = 4937466135052328149L;

	public OrchestratorException() {
		super();
	}

	public OrchestratorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OrchestratorException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrchestratorException(String message) {
		super(message);
	}

	public OrchestratorException(Throwable cause) {
		super(cause);
	}
}
