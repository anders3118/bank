package com.barclays.routing.model;

import com.barclays.routing.message.ProviderType;

public interface IOperation {

	public ProviderType getProviader (Integer id, String operation) throws Exception;
}
