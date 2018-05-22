package com.barclays.routing.model.impl;

import com.barclays.routing.message.Providers;
import com.barclays.routing.model.IListOperation;
import com.barclays.routing.util.exception.NoDataFound;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

@Service
public class ListOperation implements IListOperation{
	private static ListOperation obj;
	
	private ListOperation (){

    }
	
	public static ListOperation getInstance(){
		if(obj == null){
			return new ListOperation();
	    }
		return obj;
	}

	@Override
	public String getProviaders() throws NoDataFound , FileNotFoundException {
        String sList="";
		ArrayList<String> list = new ArrayList<String>();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("endpoint.json").getFile());

		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader(file));
		Providers providers = gson.fromJson(br, Providers.class);


		if(providers != null){
			return providers.getProviders().toString();
		}
		throw new NoDataFound("List does not exist");

	}
	

}
