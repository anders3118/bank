package com.barclays.dispatcher.clientservice;

import org.springframework.web.client.RestTemplate;

import com.barclays.dispatcher.exception.DispatcherException;
import com.barclays.dispatcher.message.routing.ProviderType;

public class RESTClient implements IClientService {

	public Object callService(ProviderType provider, String payload) {
		RestTemplate restTemplate = new RestTemplate();
		Object response = null;
		try {

			if ("GET".equalsIgnoreCase(provider.getRest().getMethod())) {
				response = restTemplate.getForObject(provider.getRest().getEndPoint(), Object.class);
			} else if ("POST".equalsIgnoreCase(provider.getRest().getMethod())) {
				response = restTemplate.postForEntity(provider.getRest().getEndPoint(), payload, Object.class);
			}
			return response;
		} catch (Exception e) {
			throw new DispatcherException("Ocurrió un error ejecutar cliente REST", e);
		}
	}

}
