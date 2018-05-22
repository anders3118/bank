/**
 * 
 */
package com.barclays.transform.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.barclays.transform.model.ListServices;
import com.barclays.transform.model.Service;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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
		String transformResult = null;
		try {
			List<Service> serviceListTransform = getTransformTable();
			String transformTemplate = SetTransformTemplate(serviceListTransform, serviceType, operation,
					operationType);
			String connectionType = SetConnectionType(serviceListTransform, serviceType, operation, operationType);
			String messageSource = null;
			TransformerFactory factory = TransformerFactory.newInstance();

			if (connectionType.equals("REST")) {
				Gson g = new Gson();
				String body = g.toJson(message);
				body = body.substring(1, body.length() - 1);
				body = body.replace("\\", "");
				JSONObject json = new JSONObject(body);
				messageSource = XML.toString(json);
				messageSource = "<root>" + messageSource + "</root>";
			} else {
				String messagebody = message;
				messagebody = messagebody.replace("\\", "");
				messageSource = messagebody;
			}

			InputStream inputStream = TransformService.class.getResourceAsStream("/app/"+transformTemplate);
			Source xslt = new StreamSource(inputStream);
			Templates cached = factory.newTemplates(xslt);
			Transformer transformer = cached.newTransformer();

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = documentBuilderFactory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(messageSource)));

			// Source source = new StreamSource(new StringReader(message));
			Source source = new DOMSource(document);
			StringWriter outWriter = new StringWriter();
			StreamResult result = new StreamResult(outWriter);
			transformer.transform(source, result);
			StringBuffer sb = outWriter.getBuffer();
			String finalstring = sb.toString();
			transformResult = finalstring;

			if (!connectionType.equals("REST")) {
				JSONObject xmlJSONObj = XML.toJSONObject(transformResult);
				transformResult = xmlJSONObj.toString();
				System.out.println(transformResult);
			}
		} catch (TransformerConfigurationException e) {
			transformResult = "Exception: se produjo un error inesperado";
			e.printStackTrace();
		} catch (TransformerException e) {
			transformResult = "Exception: se produjo un error inesperado";
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			transformResult = "Exception: se produjo un error inesperado";
			e.printStackTrace();
		} catch (SAXException e) {
			transformResult = "Exception: se produjo un error inesperado";
			e.printStackTrace();
		} catch (IOException e) {
			transformResult = "Exception: se produjo un error inesperado";
			e.printStackTrace();
		} catch (Exception e) {
			transformResult = "Exception: se produjo un error inesperado";
			e.printStackTrace();
		}
		return transformResult;
	}

	public List<Service> getTransformTable() throws JsonParseException, JsonMappingException, IOException {
		ListServices listServices = null;
		List<Service> serviceList = null;
		InputStream br = TransformService.class.getClassLoader().getResourceAsStream(TRANSFORM_TABLE);
		listServices = new ObjectMapper().readValue(br, ListServices.class);
		serviceList = listServices.getListServices();
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

	public String SetConnectionType(List<Service> services, int serviceType, String operation, String operationType) {
		String connectionType = null;
		for (Service service : services) {
			if (service.getService() == serviceType && service.getOperation().equals(operation)
					&& service.getOperationType().equals(operationType)) {
				connectionType = service.getConnectionType();
			}
		}
		return connectionType;
	}

}
