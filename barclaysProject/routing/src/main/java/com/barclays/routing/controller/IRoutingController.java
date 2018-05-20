package com.barclays.routing.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.barclays.routing.util.exception.OperationException;

public interface IRoutingController {
	public String operation (String operation , HttpServletRequest request)throws OperationException;
	public String listOperation (HttpServletRequest request) throws OperationException;
}
