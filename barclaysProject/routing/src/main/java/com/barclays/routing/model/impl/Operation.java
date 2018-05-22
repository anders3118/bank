package com.barclays.routing.model.impl;

import com.barclays.routing.client.RESTClient;
import com.barclays.routing.message.ProviderType;
import com.barclays.routing.message.Providers;
import com.barclays.routing.model.IOperation;
import com.barclays.routing.util.exception.NoDataFound;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

@Service
public class Operation implements IOperation{

	private static Operation obj;

	@Autowired
	private RESTClient restClient;

	private Operation (){

	}

	public static Operation getInstance(){
		if(obj == null){
			return new Operation();
		}
		return obj;
	}

	@Override
	public ProviderType getProviader(Integer id , String operation) throws NoDataFound , FileNotFoundException ,URISyntaxException, MalformedURLException{


		String sRouting= restClient.callService("https://s3.amazonaws.com/modelo-arq/routing/endpoint.json", String.class);

		Gson gson = new Gson();
		Providers providers = gson.fromJson(sRouting , Providers.class);

		if(providers != null){
			Optional <ProviderType> opt =providers.getProviders().stream().filter(provider -> id == provider.getId() && operation.equalsIgnoreCase(provider.getOperation().toString())).findFirst();

			if(opt.isPresent()){
				return opt.get();
			}

		}
		throw new NoDataFound("this operation does not exist");
	}

}
