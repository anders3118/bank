package com.barclays.dispatcher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.barclays.dispatcher.clientservice.RESTClient;
import com.barclays.dispatcher.clientservice.SOAPClient;

@Component
public class ClientServiceComponent {

	@Bean
	public RESTClient getRestClient() {
		return new RESTClient();
	}

	@Bean
	public SOAPClient getSoapClient() {
		return new SOAPClient();
	}
}
