package com.barclays.routing.controller;

import com.barclays.routing.message.ProviderType;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.barclays.routing.util.exception.NoDataFound;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;

public interface IRoutingController {
	public ResponseEntity<ProviderType> operation (Integer id, String operation , HttpServletRequest request)throws NoDataFound , FileNotFoundException;
	public String listOperation (HttpServletRequest request) throws NoDataFound, FileNotFoundException;
}
