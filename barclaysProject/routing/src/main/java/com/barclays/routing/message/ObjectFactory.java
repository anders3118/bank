//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.20 a las 12:51:22 PM COT 
//


package com.barclays.routing.message;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.barclays.routing.message package. 
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

    private final static QName _Provider_QNAME = new QName("http://barclays.com/message/bussines/services", "provider");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.barclays.routing.message
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProviderType }
     * 
     */
    public ProviderType createProviderType() {
        return new ProviderType();
    }

    /**
     * Create an instance of {@link RestType }
     * 
     */
    public RestType createRestType() {
        return new RestType();
    }

    /**
     * Create an instance of {@link SoapType }
     * 
     */
    public SoapType createSoapType() {
        return new SoapType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProviderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://barclays.com/message/bussines/services", name = "provider")
    public JAXBElement<ProviderType> createProvider(ProviderType value) {
        return new JAXBElement<ProviderType>(_Provider_QNAME, ProviderType.class, null, value);
    }

}
