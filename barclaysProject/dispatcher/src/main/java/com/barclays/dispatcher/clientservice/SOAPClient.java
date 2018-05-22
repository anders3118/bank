package com.barclays.dispatcher.clientservice;

import java.io.StringReader;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.barclays.dispatcher.exception.DispatcherException;
import com.barclays.dispatcher.message.ProviderType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SOAPClient {

	public String callService(ProviderType provider, String payload) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			QName qServiceName = new QName(provider.getSoap().getTargetNameSpace(),
					provider.getSoap().getServiceName());
			QName qPortName = new QName(provider.getSoap().getTargetNameSpace(), provider.getSoap().getServicePort());

			Service service = Service.create(qServiceName);
			service.addPort(qPortName, SOAPBinding.SOAP11HTTP_BINDING, provider.getSoap().getEndpoint());

			Dispatch<SOAPMessage> dispatch = service.createDispatch(qPortName, SOAPMessage.class, Service.Mode.MESSAGE);

			dispatch.getRequestContext().put(Dispatch.SOAPACTION_USE_PROPERTY, true);
			dispatch.getRequestContext().put(Dispatch.SOAPACTION_URI_PROPERTY, provider.getSoap().getOperation());

			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();

			SOAPPart soapPart = message.getSOAPPart();

			StreamSource source = new StreamSource(new StringReader(payload));
			soapPart.setContent(source);

			message.saveChanges();
			SOAPMessage response = (SOAPMessage) dispatch.invoke(message);

			SOAPBody soapBody = response.getSOAPBody();
			SOAPBodyElement bodyElement = (SOAPBodyElement) soapBody.getChildElements().next();

			return mapper.writeValueAsString(bodyElement);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DispatcherException("Ocurrió un error ejecutar cliente SOAP", e);
		}
	}

}