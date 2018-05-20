/**
 * 
 */
package com.barclays.transform.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.barclays.transform.model.ListServices;
import com.barclays.transform.model.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author marco.caipe
 *
 */
public class TransformService {

	/**
	 * 
	 */
	public final String TRANSFORM_TABLE = "TranformServicesTable.json";

	public TransformService() {
		// TODO Auto-generated constructor stub
	}

	public void TransformXSLT(int serviceType, String operation, String message) {
		ClassLoader classLoader = getClass().getClassLoader();
		List<Service> serviceListTransform = getTransformTable();
		String transformTemplate = SetTransformTemplate(serviceListTransform, serviceType, operation);
		
		
		try {
			TransformerFactory factory = TransformerFactory.newInstance();

			Source xslt = new StreamSource(new File(classLoader.getResource(transformTemplate).getFile()));
			Transformer transformer = factory.newTransformer(xslt);
			Source source = new StreamSource(new StringReader(message));
			StreamResult result = new StreamResult(System.out);
		    transformer.transform(source, result);
		    System.out.println(result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Service> getTransformTable() {
		ClassLoader classLoader = getClass().getClassLoader();
		ListServices listServices = null;
		List<Service> serviceList = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(classLoader.getResource(TRANSFORM_TABLE).getFile()));
			listServices = new ObjectMapper().readValue(br, ListServices.class);
			serviceList = listServices.getListServices();
			//System.out.println(listServices.getListServices().get(0).getTransformName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviceList;
	}

	public String SetTransformTemplate(List<Service> services, int serviceType, String operation) {
		String transformTemplate = null;
		for (Service service : services) {
			if (service.getService() == serviceType && service.getOperation().equals(operation)) {
				transformTemplate = service.getTransformName();
			}
		}
		System.out.println(transformTemplate);
		return transformTemplate;
	}

}
