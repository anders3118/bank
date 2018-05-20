package com.barclays.dispatcher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.barclays.dispatcher.clientservice.IClientService;
import com.barclays.dispatcher.clientservice.RESTClient;
import com.barclays.dispatcher.clientservice.SOAPClient;

@Component
public class ClientServiceComponent {

	@Bean
	public IClientService getRestClient() {
		return new RESTClient();
	}

	@Bean
	public IClientService getSoapClient() {
		return new SOAPClient();
	}
}
