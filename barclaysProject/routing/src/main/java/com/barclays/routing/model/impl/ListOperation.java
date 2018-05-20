package com.barclays.routing.model.impl;

import com.barclays.routing.model.IListOperation;
import com.barclays.routing.util.exception.OperationException;
import org.springframework.stereotype.Service;

@Service
public class ListOperation implements IListOperation{
	private static ListOperation obj;
	
	private ListOperation (){

    }
	
	public static ListOperation getInstance(){
		if(obj == null){
			return new ListOperation();
	    }
		return obj;
	}

	@Override
	public String listOperation() throws OperationException {
		// TODO Auto-generated method stub
		String Services = "Listado";
		return Services;
	}
	

}
