package com.barclays.dispatcher.clientservice;

import com.barclays.dispatcher.message.routing.ProviderType;

/**
 * 
 * @author anders.barrios
 *
 */
public interface IClientService {

	/**
	 * 
	 * @param provider
	 * @param payload
	 * @return
	 */
	String callService(ProviderType provider, String payload);
}
