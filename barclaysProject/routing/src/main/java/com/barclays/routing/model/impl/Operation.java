package com.barclays.routing.model.impl;

import com.barclays.routing.message.ProviderType;
import com.barclays.routing.message.Providers;
import com.barclays.routing.model.IOperation;
import com.barclays.routing.util.exception.NoDataFound;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;

@Service
public class Operation implements IOperation{

	private static Operation obj;

	private Operation (){

	}

	public static Operation getInstance(){
		if(obj == null){
			return new Operation();
		}
		return obj;
	}

	@Override
	public ProviderType getProviader(Integer id , String operation) throws NoDataFound , FileNotFoundException {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("endpoint.json").getFile());

		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader(file));
		Providers providers = gson.fromJson(br, Providers.class);

		if(providers != null){
			Optional <ProviderType> opt =providers.getProviders().stream().filter(provider -> id == provider.getId() && operation.equalsIgnoreCase(provider.getOperation().toString())).findFirst();

			if(opt.isPresent()){
				return opt.get();
			}

		}
		throw new NoDataFound("this operation does not exist");
	}

}
