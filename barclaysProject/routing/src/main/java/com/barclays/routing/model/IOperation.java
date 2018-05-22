package com.barclays.routing.model;

import com.barclays.routing.message.ProviderType;
import com.barclays.routing.model.impl.Provider;
import com.barclays.routing.util.exception.NoDataFound;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Optional;

public interface IOperation {

	public ProviderType getProviader (Integer id, String operation) throws NoDataFound , FileNotFoundException , URISyntaxException , MalformedURLException;
}
