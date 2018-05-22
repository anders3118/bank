//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.21 a las 11:38:37 PM COT 
//


package com.barclays.dispatcher.message;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SoapType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SoapType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="endpoint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targetNameSpace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serviceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="servicePort" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoapType", propOrder = {
    "endpoint",
    "targetNameSpace",
    "serviceName",
    "servicePort",
    "operation"
})
public class SoapType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String endpoint;
    @XmlElement(required = true)
    protected String targetNameSpace;
    @XmlElement(required = true)
    protected String serviceName;
    @XmlElement(required = true)
    protected String servicePort;
    protected String operation;

    /**
     * Obtiene el valor de la propiedad endpoint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Define el valor de la propiedad endpoint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndpoint(String value) {
        this.endpoint = value;
    }

    /**
     * Obtiene el valor de la propiedad targetNameSpace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetNameSpace() {
        return targetNameSpace;
    }

    /**
     * Define el valor de la propiedad targetNameSpace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetNameSpace(String value) {
        this.targetNameSpace = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Define el valor de la propiedad serviceName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Obtiene el valor de la propiedad servicePort.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicePort() {
        return servicePort;
    }

    /**
     * Define el valor de la propiedad servicePort.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicePort(String value) {
        this.servicePort = value;
    }

    /**
     * Obtiene el valor de la propiedad operation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Define el valor de la propiedad operation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

}
