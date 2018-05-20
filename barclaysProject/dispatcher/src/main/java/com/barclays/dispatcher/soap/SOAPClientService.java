package com.barclays.dispatcher.soap;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.barclays.dispatcher.exception.DispatcherException;

public class SOAPClientService  {

	/**
	 * 
	 * @param endpointURL
	 * @param targeNameSpace
	 * @param serviceName
	 * @param servicePort
	 * @param soapAction
	 * @param requestData
	 * @return
	 */
	public SOAPMessage callService(String endpointURL, String targeNameSpace, String serviceName,
			String servicePort, String soapAction, String requestData) {

		try {

			QName qServiceName = new QName(targeNameSpace, serviceName);
			QName qPortName = new QName(targeNameSpace, servicePort);

			Service service = Service.create(qServiceName);
			service.addPort(qPortName, SOAPBinding.SOAP11HTTP_BINDING, endpointURL);

			Dispatch<SOAPMessage> dispatch = service.createDispatch(qPortName, SOAPMessage.class, Service.Mode.MESSAGE);

			dispatch.getRequestContext().put(Dispatch.SOAPACTION_USE_PROPERTY, true);
			dispatch.getRequestContext().put(Dispatch.SOAPACTION_URI_PROPERTY, soapAction);

			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();

			SOAPPart soapPart = message.getSOAPPart();
			SOAPEnvelope envelope = soapPart.getEnvelope();
			SOAPBody body = envelope.getBody();

			// StreamSource source = new StreamSource(new StringReader(requestData));
			// soapPart.setContent(source);

			body.getFirstChild().setTextContent(requestData);

			message.saveChanges();
			SOAPMessage response = (SOAPMessage) dispatch.invoke(message);

			return response;
		} catch (Exception e) {
			throw new DispatcherException("Ocurrió un error al crear service port", e);
		}
	}

}
