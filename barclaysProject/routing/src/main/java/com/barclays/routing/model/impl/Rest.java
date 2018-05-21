
package com.barclays.routing.model.impl;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rest {

    @SerializedName("endPoint")
    @Expose
    private String endPoint;
    @SerializedName("method")
    @Expose
    private String method;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}