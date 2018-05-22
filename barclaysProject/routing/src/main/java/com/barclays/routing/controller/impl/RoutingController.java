package com.barclays.routing.controller.impl;

import com.barclays.routing.controller.IRoutingController;
import com.barclays.routing.message.ProviderType;
import com.barclays.routing.model.IListOperation;
import com.barclays.routing.model.IOperation;
import com.barclays.routing.util.exception.NoDataFound;

import com.google.gson.Gson;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class RoutingController implements IRoutingController {
	
	
   @Autowired
   private IOperation iOperation;
   
   @Autowired
   private IListOperation iListOperation;
	
   @RequestMapping("/v1")
   public String listOperation(HttpServletRequest request) throws NoDataFound , FileNotFoundException {

      return iListOperation.getProviaders();
    }

   @RequestMapping("/v1/{id}/{operation}")
   public ResponseEntity<ProviderType> operation(@PathVariable("id") Integer id, @PathVariable("operation") String operation, HttpServletRequest request) throws NoDataFound  ,  FileNotFoundException {
      ResponseEntity<ProviderType>  response = null;
      try {
         ProviderType provider = iOperation.getProviader(id, operation);
         response = new ResponseEntity<>(provider,HttpStatus.OK);

      }catch (Exception e ) {
         response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return response;

   }

	 
}
