package com.barclays.routing.model;

import com.barclays.routing.model.impl.Provider;
import com.barclays.routing.util.exception.NoDataFound;

import java.io.FileNotFoundException;
import java.util.Optional;

public interface IOperation {

	public Provider getProviader (String id, String operation) throws NoDataFound , FileNotFoundException;
}
