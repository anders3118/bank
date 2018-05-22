package com.barclays.routing.message;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Providers {
    @SerializedName("providers")
    @Expose
    private List<ProviderType> providers = null;

    public List<ProviderType> getProviders() {
        return providers;
    }

    public void setProviders(List<ProviderType> providers) {
        this.providers = providers;
    }
}
