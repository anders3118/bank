package com.barclays.routing.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.barclays.routing.util.exception.NoDataFound;

import java.io.FileNotFoundException;

public interface IRoutingController {
	public String operation (String id, String operation , HttpServletRequest request)throws NoDataFound , FileNotFoundException;
	public String listOperation (HttpServletRequest request) throws NoDataFound, FileNotFoundException;
}
