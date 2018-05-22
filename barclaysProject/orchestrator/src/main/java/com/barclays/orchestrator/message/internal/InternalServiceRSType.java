//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.21 a las 10:07:08 PM COT 
//


package com.barclays.orchestrator.message.internal;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InternalServiceRSType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InternalServiceRSType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="internalResponse" type="{http://barclays.com/message/bussines/services}InternalResponseType"/>
 *         &lt;element name="serviceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InternalServiceRSType", propOrder = {
    "internalResponse",
    "serviceType"
})
public class InternalServiceRSType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected InternalResponseType internalResponse;
    @XmlElement(required = true)
    protected String serviceType;

    /**
     * Obtiene el valor de la propiedad internalResponse.
     * 
     * @return
     *     possible object is
     *     {@link InternalResponseType }
     *     
     */
    public InternalResponseType getInternalResponse() {
        return internalResponse;
    }

    /**
     * Define el valor de la propiedad internalResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalResponseType }
     *     
     */
    public void setInternalResponse(InternalResponseType value) {
        this.internalResponse = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Define el valor de la propiedad serviceType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

}
