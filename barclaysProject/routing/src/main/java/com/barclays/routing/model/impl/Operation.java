package com.barclays.routing.model.impl;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.routing.client.RESTClient;
import com.barclays.routing.message.ProviderType;
import com.barclays.routing.message.Providers;
import com.barclays.routing.model.IOperation;
import com.barclays.routing.util.exception.NoDataFound;
import com.google.gson.Gson;

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
			throws NoDataFound, FileNotFoundException, URISyntaxException, MalformedURLException {

		String sRouting = restClient.callService("https://s3.amazonaws.com/modelo-arq/routing/endpoint.json",
				String.class);

		Gson gson = new Gson();
		Providers providers = gson.fromJson(sRouting, Providers.class);
		ProviderType providerType = null;

		if (providers != null) {
			// Optional<ProviderType> opt =
			// providers.getProviders().stream().filter(provider -> id == provider.getId()
			// &&
			// operation.equalsIgnoreCase(provider.getOperation().toString())).findFirst();

			// while (recaudoIterator.hasNext()) {
			for (ProviderType provider : providers.getProviders()) {
				System.out.println(provider.getId().intValue());
				System.out.println(id.intValue());
				System.out.println(provider.getOperation());
				System.out.println(operation.toUpperCase());
				int providerInt = provider.getId().intValue();
				System.out.println(providerInt);
				int idInt = id.intValue();
				System.out.println(idInt);
				operation = operation.toUpperCase();
				operation = operation.trim();
				String operationProvider = provider.getOperation().toUpperCase();
				operationProvider.trim();
				System.out.println(operation);
				System.out.println(operationProvider);
				if (provider.getId() == id && operation.equals(operationProvider)) {
					providerType = provider;
					System.out.println("eNTRO AQUI");
				}
			}
			return providerType;
			// if (opt.isPresent()) {
			// return providerType;
			// }

		}
		throw new NoDataFound("this operation does not exist");
	}

}
