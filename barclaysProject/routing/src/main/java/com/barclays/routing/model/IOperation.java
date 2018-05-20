package com.barclays.routing.model;

import com.barclays.routing.util.exception.OperationException;

public interface IOperation {

	public String getOperation (String operation) throws OperationException;
}
