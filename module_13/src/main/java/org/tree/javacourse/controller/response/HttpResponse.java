package org.tree.javacourse.controller.response;

import com.google.gson.JsonElement;

public class HttpResponse {
    private String statusReponse;
    private JsonElement data;

    public HttpResponse(String statusReponse, JsonElement data) {
        this.statusReponse = statusReponse;
        this.data = data;
    }

    public HttpResponse(String statusReponse) {
        this.statusReponse = statusReponse;
    }

    public String getStatusReponse() {
        return statusReponse;
    }

    public void setStatusReponse(String statusReponse) {
        this.statusReponse = statusReponse;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }

}

