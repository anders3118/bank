
package com.barclays.routing.model.impl;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Soap {

    @SerializedName("endpoint")
    @Expose
    private String endpoint;
    @SerializedName("targetNameSpace")
    @Expose
    private String targetNameSpace;
    @SerializedName("serviceName")
    @Expose
    private String serviceName;
    @SerializedName("servicePort")
    @Expose
    private String servicePort;
    @SerializedName("operation")
    @Expose
    private String operation;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getTargetNameSpace() {
        return targetNameSpace;
    }

    public void setTargetNameSpace(String targetNameSpace) {
        this.targetNameSpace = targetNameSpace;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}