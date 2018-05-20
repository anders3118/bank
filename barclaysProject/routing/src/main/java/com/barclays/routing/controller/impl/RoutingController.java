package com.barclays.routing.controller.impl;

import com.barclays.routing.controller.IRoutingController;
import com.barclays.routing.model.IListOperation;
import com.barclays.routing.model.IOperation;
import com.barclays.routing.util.exception.OperationException;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutingController implements IRoutingController {
	
	
   @Autowired
   private IOperation iOperation;
   
   @Autowired
   private IListOperation iListOperation;
	
   @RequestMapping("/v1/routing")
   public String listOperation(HttpServletRequest request) throws OperationException {

        return iListOperation.listOperation();
    }

   @RequestMapping("/v1/routing/{operation}")
   public String operation(@PathVariable("operation") String operation, HttpServletRequest request) throws OperationException {

	   return iOperation.getOperation(operation);
   }

	 
}
