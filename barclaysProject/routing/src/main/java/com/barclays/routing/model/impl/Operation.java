package com.barclays.routing.model.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.routing.client.RESTClient;
import com.barclays.routing.message.ProviderType;
import com.barclays.routing.message.Providers;
import com.barclays.routing.model.IOperation;
import com.barclays.routing.util.exception.NoDataFound;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Operation implements IOperation {

	private static Operation obj;

	@Autowired
	private RESTClient restClient;

	private Operation() {

	}

	public static Operation getInstance() {
		if (obj == null) {
			return new Operation();
		}
		return obj;
	}

	@Override
	public ProviderType getProviader(Integer id, String operation)
			throws Exception{

		String sRouting = restClient.callService("https://s3.amazonaws.com/modelo-arq/routing/endpoint.json",
				String.class);

		ObjectMapper mapper = new ObjectMapper();
		Providers providers = mapper.readValue(sRouting, Providers.class);

		if (providers != null) {
			Optional<ProviderType> opt = providers.getProviders().stream().filter(p -> p.getId().equals(id)
					&& p.getOperation().equalsIgnoreCase(operation)).findFirst();
		
			if (opt.isPresent()) {
				return opt.get();
			}

		}
		throw new NoDataFound("this operation does not exist");
	}

}
