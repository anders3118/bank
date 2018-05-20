package com.barclays.routing.model.impl;

import com.barclays.routing.model.IOperation;
import com.barclays.routing.util.exception.OperationException;
import org.springframework.stereotype.Service;

@Service
public class Operation implements IOperation{

	@Override
	public String getOperation(String operation) throws OperationException {
		// TODO Auto-generated method stub
		String endPoint = "http://localhost:7070/w1-soap-svr/PagosServiceService?wsdl";
		return endPoint;
	}

}
