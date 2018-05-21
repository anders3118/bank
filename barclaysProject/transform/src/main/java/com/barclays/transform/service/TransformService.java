/**
 * 
 */
package com.barclays.transform.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

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
		super();
	}

	public String TransformXSLT(int serviceType, String operation, String operationType, String message) {
		ClassLoader classLoader = getClass().getClassLoader();
		List<Service> serviceListTransform = getTransformTable();
		String transformTemplate = SetTransformTemplate(serviceListTransform, serviceType, operation, operationType);
		String transformResult = null;

		try {
			TransformerFactory factory = TransformerFactory.newInstance();

			Source xslt = new StreamSource(new File(classLoader.getResource(transformTemplate).getFile()));
			Transformer transformer = factory.newTransformer(xslt);
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();  
			DocumentBuilder builder; 
			builder = documentBuilderFactory.newDocumentBuilder();  
		    Document document = builder.parse(new InputSource(new StringReader(message))); 
			
			//Source source = new StreamSource(new StringReader(message));
		    Source source = new DOMSource(document);
		    StringWriter outWriter = new StringWriter();
			StreamResult result = new StreamResult(outWriter);
			transformer.transform(source, result);
			StringBuffer sb = outWriter.getBuffer(); 
			String finalstring = sb.toString();
			transformResult = finalstring;
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transformResult;
	}

	public List<Service> getTransformTable() {
		ClassLoader classLoader = getClass().getClassLoader();
		ListServices listServices = null;
		List<Service> serviceList = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(classLoader.getResource(TRANSFORM_TABLE).getFile()));
			listServices = new ObjectMapper().readValue(br, ListServices.class);
			serviceList = listServices.getListServices();
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return serviceList;
	}

	public String SetTransformTemplate(List<Service> services, int serviceType, String operation,
			String operationType) {
		String transformTemplate = null;
		for (Service service : services) {
			if (service.getService() == serviceType && service.getOperation().equals(operation)
					&& service.getOperationType().equals(operationType)) {
				transformTemplate = service.getTransformName();
			}
		}
		return transformTemplate;
	}

}
