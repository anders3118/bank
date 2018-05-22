package com.barclays.dispatcher.clientservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.barclays.dispatcher.exception.DispatcherException;
import com.barclays.dispatcher.message.ProviderType;

public class RESTClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(RESTClient.class);

	private RestTemplate restTemplate;

	public RESTClient() {
		this.restTemplate = new RestTemplate();
	}

	@SuppressWarnings("unchecked")
	public <T> T callService(ProviderType provider, Object payload, Class<?> clazz) {
		ResponseEntity<T> response = null;
		LOGGER.info(String.format("Consumiendo servicio %s", provider.getRest().getEndPoint()));

		try {

			if ("GET".equalsIgnoreCase(provider.getRest().getMethod())) {
				response = (ResponseEntity<T>) restTemplate.getForEntity(provider.getRest().getEndPoint(), clazz);
				return getBody(response);
			} else if ("POST".equalsIgnoreCase(provider.getRest().getMethod())) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<Object> entity = new HttpEntity<>(payload, headers);
				response = (ResponseEntity<T>) restTemplate.postForEntity(provider.getRest().getEndPoint(), entity, clazz);
				return getBody(response);
			}

			throw new DispatcherException(
					String.format("Método http %s no configurado", provider.getRest().getMethod()));

		} catch (Exception e) {
			throw new DispatcherException("Ocurrió un error ejecutar cliente REST", e);
		}
	}

	@SuppressWarnings("unchecked")
	private <T> T getBody(ResponseEntity<?> response) {
		LOGGER.info(
				String.format("Se obtuvo código de respuesta %d al llamar al servicio", response.getStatusCodeValue()));
		if (200 == response.getStatusCodeValue()) {
			return (T) response.getBody();
		} else {
			throw new DispatcherException(String.format("Se obtuvo código de respuesta %d al llamar al servicio",
					response.getStatusCodeValue()));
		}
	}

}