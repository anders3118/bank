package com.barclays.routing.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RESTClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RESTClient.class);

    private RestTemplate restTemplate;

    public RESTClient() {
        this.restTemplate = new RestTemplate();
    }

    @SuppressWarnings("unchecked")
    public <T> T callService(String endPoint, Class<?> clazz) {
        ResponseEntity<T> response = null;

        try {
            response = (ResponseEntity<T>) restTemplate.getForEntity(endPoint, clazz);
            return getBody(response);

        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error al obtener el archivo", e);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T getBody(ResponseEntity<?> response) {
        LOGGER.info(
                String.format("Se obtuvo código de respuesta %d al llamar al servicio", response.getStatusCodeValue()));
        if (200 == response.getStatusCodeValue() || 304 == response.getStatusCodeValue()) {
            return (T) response.getBody();
        } else {
            throw new RuntimeException(String.format("Se obtuvo código de respuesta %d al llamar al servicio",
                    response.getStatusCodeValue()));
        }
    }

}