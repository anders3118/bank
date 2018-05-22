//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.22 a las 11:45:57 AM COT 
//


package com.barclays.orchestrator.message.internal;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.barclays.orchestrator.message.internal package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.barclays.orchestrator.message.internal
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RestType }
     * 
     */
    public RestType createRestType() {
        return new RestType();
    }

    /**
     * Create an instance of {@link InternalResponseType }
     * 
     */
    public InternalResponseType createInternalResponseType() {
        return new InternalResponseType();
    }

    /**
     * Create an instance of {@link InternalServiceRSType }
     * 
     */
    public InternalServiceRSType createInternalServiceRSType() {
        return new InternalServiceRSType();
    }

    /**
     * Create an instance of {@link InternalRequestType }
     * 
     */
    public InternalRequestType createInternalRequestType() {
        return new InternalRequestType();
    }

    /**
     * Create an instance of {@link SoapType }
     * 
     */
    public SoapType createSoapType() {
        return new SoapType();
    }

    /**
     * Create an instance of {@link InternalServiceRQType }
     * 
     */
    public InternalServiceRQType createInternalServiceRQType() {
        return new InternalServiceRQType();
    }

    /**
     * Create an instance of {@link ProviderType }
     * 
     */
    public ProviderType createProviderType() {
        return new ProviderType();
    }

}
