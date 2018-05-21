package com.barclays.dispatcher.clientservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.barclays.dispatcher.exception.DispatcherException;
import com.barclays.dispatcher.message.routing.ProviderType;

public class RESTClient implements IClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RESTClient.class);

	private RestTemplate restTemplate;

	public RESTClient() {
		this.restTemplate = new RestTemplate();
	}

	public String callService(ProviderType provider, String payload) {
		ResponseEntity<String> response = null;

		try {

			if ("GET".equalsIgnoreCase(provider.getRest().getMethod())) {
				response = restTemplate.getForEntity(provider.getRest().getEndPoint(), String.class);
				return getBody(response);
			} else if ("POST".equalsIgnoreCase(provider.getRest().getMethod())) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> entity = new HttpEntity<String>(payload, headers);
				response = restTemplate.postForEntity(provider.getRest().getEndPoint(), entity, String.class);
				return getBody(response);
			}

			throw new DispatcherException(
					String.format("Método http %s no configurado", provider.getRest().getMethod()));

		} catch (Exception e) {
			throw new DispatcherException("Ocurrió un error ejecutar cliente REST", e);
		}
	}

	private String getBody(ResponseEntity<String> response) {
		LOGGER.info(
				String.format("Se obtuvo código de respuesta %d al llamar al servicio", response.getStatusCodeValue()));
		if (200 == response.getStatusCodeValue()) {
			return response.getBody();
		} else {
			throw new DispatcherException(String.format("Se obtuvo código de respuesta %d al llamar al servicio",
					response.getStatusCodeValue()));
		}
	}

}